package com.wt.flink.watermark;

import com.google.gson.Gson;
import com.wt.flink.pojo.AlarmParam;
import com.wt.flink.pojo.FlinkAlertRule;
import com.wt.flink.utils.LineMessage;
import com.wt.flink.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

import java.time.Duration;
import java.time.Instant;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/6/25 14:33
 */
@Slf4j
public class FlinkTest {
    private static AlarmParam alarmParam;
    private static Long alertId;
    private static Gson gson = new Gson();
    private static final Integer PARALLELISM = 2;
    private static final Integer DELAY_INTERVAL = 1 * 60 * 1000;

    public static void main(String[] args) throws Exception {
        log.info("start flink milog alarm");
        //从命令参数中获取所需配置信息
        alarmParam = Utils.parseParams(args);
        log.info("flink start param:{}", alarmParam);

        alertId = alarmParam.getAlertId();
        // 获取flink运行环境
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        setCheckPointConfig(environment);
        //从talos中获取数据源后周期性的生成水印
        DataStream<LineMessage> logSourceStream = buildDataStream(environment)
                .map((P) -> gson.fromJson(P, LineMessage.class))
                .assignTimestampsAndWatermarks(WatermarkStrategy.<LineMessage>forBoundedOutOfOrderness(Duration.ofMillis(DELAY_INTERVAL))
                        .withTimestampAssigner(new SerializableTimestampAssigner<LineMessage>() {
                            @Override
                            public long extractTimestamp(LineMessage lineMessage, long recordTimestamp) {
                                String timeSmpStr = lineMessage.getExtMap().get(LineMessage.KEY_COLLECT_TIMESTAMP);
                                long timeSmp;
                                if (StringUtils.isNotEmpty(timeSmpStr)) {
                                    timeSmp = Long.valueOf(timeSmpStr);
                                } else {
                                    timeSmp = Instant.now().toEpochMilli();
                                }
                                return timeSmp;
                            }
                        }));
        DataStream<Tuple3<LineMessage, FlinkAlertRule, Integer>> matchStream =
                logSourceStream.flatMap(null);
        // 开窗聚合统计--定义滚动时间窗口一分钟统计一次
        WindowedStream<Tuple3<LineMessage, FlinkAlertRule, Integer>, Long, TimeWindow> streamOperator = matchStream.keyBy(data -> data.f1.getRuleId())
                .window(TumblingEventTimeWindows.of(Time.milliseconds(DELAY_INTERVAL)))
                ;
        //自定义触发器触发窗口
        streamOperator.trigger(LogTrigger.create(DELAY_INTERVAL));

        SingleOutputStreamOperator<Tuple3<LineMessage, FlinkAlertRule, Integer>> outputStreamOperator = streamOperator.reduce((P, Q) -> {
            return Tuple3.of(P.f0, P.f1, P.f2 + Q.f2);
        });
        // 组装数据
//        DataStream<AlertInfo> countStream = outputStreamOperator.map(new AlertFunction(alertId));

//        // 本地打印，方便调试
//        countStream.print("milog-alarm");
//        // sink 进 talos
//        countStream.addSink(MqProducer.getProducer(alarmParam));
        environment.execute(String.format("milog-alarm job start,alertId:%s", alertId));
    }

    private static DataStream<String> buildDataStream(StreamExecutionEnvironment environment) {
        DataStream<String> dataStream = null;
        return dataStream;
    }

    private static void setCheckPointConfig(StreamExecutionEnvironment environment) {
        // 设置检查点，应用重启容错性
        CheckpointConfig config = environment.getCheckpointConfig();
        // Checkpoint的触发频率；
        config.setCheckpointInterval(5 * 60 * 1000);
        // Checkpoint之间的最小间隔；
        config.setMinPauseBetweenCheckpoints(5 * 60 * 1000);
        // Checkpoint的超时时间；
        config.setCheckpointTimeout(10 * 60 * 1000);
        // 连续3次checkpoint失败，才会导致作业失败重启；默认值是0 。
        config.setTolerableCheckpointFailureNumber(3);
        // Cancel Job之后保留Checkpoint文件；
        config.enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
    }
}
