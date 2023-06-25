package com.wt.flink.utils;

import com.wt.flink.pojo.AlarmParam;
import com.wt.flink.pojo.FlinkAlertRule;
import com.wt.flink.pojo.FlinkRuleEvent;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.java.utils.ParameterTool;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/6/25 10:06
 */
public class Utils {
    public static AlarmParam parseParams(String[] args) {
        AlarmParam alarmParam = new AlarmParam();
        if (args == null || args.length == 0) {
            return alarmParam;
        }
        ParameterTool tool = ParameterTool.fromArgs(args);
        alarmParam.setAccessKey(tool.get(Constant.ACCESS_KEY));
        alarmParam.setSecretKey(tool.get(Constant.SECRET_KEY));
        alarmParam.setProducerAccessKey(tool.get(Constant.PRODUCER_ACCESS_KEY));
        alarmParam.setProducerSecretKey(tool.get(Constant.PRODUCER_SECRET_KEY));
        alarmParam.setAlertId(Long.parseLong(tool.get(Constant.ALERT_ID)));

        alarmParam.setConsumerServer(tool.get(Constant.CONSUMER_SERVER));
        alarmParam.setProducerServer(tool.get(Constant.PRODUCER_SERVER));
        alarmParam.setConsumerTopic(tool.get(Constant.CONSUMER_TOPIC));
        alarmParam.setProducerTopic(tool.get(Constant.PRODUCER_TOPIC));

        //   params.setWindowSize(Integer.parseInt(tool.get(Constant.WINDOW_SIZE)));
        //  params.setWindowOffset(Integer.parseInt(tool.get(Constant.WINDOW_OFFSET)));

        alarmParam.setMqType(tool.get(Constant.MQ_TYPE));
        alarmParam.setConsumerGroup(tool.get(Constant.CONSUMER_GROUP));
        alarmParam.setConsumerTag(tool.get(Constant.CONSUMER_TAG));
        alarmParam.setAlertRulesInput(tool.get(Constant.ALERT_RULES_INPUT));
        String parallelismStr = tool.get(Constant.ALERT_PARALLELISM);
        if (StringUtils.isNotBlank(parallelismStr)) {
            alarmParam.setParallelism(Integer.parseInt(parallelismStr));
        }
        String userSet = tool.get(Constant.USER_SET);
        if (StringUtils.isNotBlank(userSet)) {
            alarmParam.setUserSet(Integer.parseInt(userSet));
        }
        return alarmParam;
    }

    public static void loadMap(FlinkRuleEvent input) {
        List<FlinkAlertRule> alertRules = input.getAlertRules();
        if (CollectionUtils.isNotEmpty(alertRules)) {
            for (FlinkAlertRule current : alertRules) {
                try {
                    current.setPattern(Pattern.compile(current.getFilterRegex(), Pattern.MULTILINE));
                } catch (Exception e) {
                    current.setPattern(null);
                }
            }
        }

    }

    private void testRegex(List<FlinkAlertRule> alertRules) {
        FlinkAlertRule flinkAlertRule = new FlinkAlertRule();
        flinkAlertRule.setRuleId(0L);
        flinkAlertRule.setFilterRegex(".*INFO*.");
        flinkAlertRule.setPattern(Pattern.compile(".*INFO*.", Pattern.MULTILINE));
        alertRules.add(flinkAlertRule);
        FlinkAlertRule flinkAlertRule1 = new FlinkAlertRule();
        flinkAlertRule1.setRuleId(1L);
        flinkAlertRule1.setFilterRegex(".*Running*.");
        flinkAlertRule1.setPattern(Pattern.compile(".*Running*.", Pattern.MULTILINE));
        alertRules.add(flinkAlertRule1);
    }
}
