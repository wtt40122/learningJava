package com.wt.tmall.jmh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author: wtt
 * @date: 2022/5/27 19:04
 * @description:
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Threads(2)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
public class JsonBenchmark {

    private Gson gson = new Gson();
    private ObjectMapper objectMapper = new ObjectMapper();

    String str = "{\"startDate\":\"2020-04-01     16:00:00\",\"endDate\":\"2020-05-20 13:00:00\"" +
            ",\"flag\":true,\"threads\":5,\"shardingIndex\":0}";

    @Param(value =
            {"{\"startDate\":\"2020-04-01 16:00:00\",\"endDate\":\"2020-05-20 13:00:00\",\"flag\":true,\"threads\":5,\"shardingIndex\":0}",
                    "{\"startDate\":\"2020-04-01 16:00:00\",\"endDate\":\"2020-05-20 14:00:00\"}",
                    "{\"flag\":true,\"threads\":5,\"shardingIndex\":0}"})
    private String jsonStr;

    public JsonBenchmark() {
    }

    @Test
    @Benchmark
    public void testGson() {
        gson.fromJson(jsonStr, JsonTestModel.class);
        System.out.println("current Thread:" + Thread.currentThread().getName() + "==>" + gson.hashCode());
    }

    @Benchmark
    @Test
    public void testJackson() throws JsonProcessingException {
        objectMapper.readValue(jsonStr, JsonTestModel.class);
    }
}
