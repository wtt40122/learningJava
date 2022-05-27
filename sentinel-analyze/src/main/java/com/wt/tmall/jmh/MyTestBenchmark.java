package com.wt.tmall.jmh;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author: wtt
 * @date: 2022/5/27 18:43
 * @description:
 */


public class MyTestBenchmark {


    @Threads(2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Benchmark
    @Test
    public void testFunction() {
        System.out.printf("fdsf");
    }
}
