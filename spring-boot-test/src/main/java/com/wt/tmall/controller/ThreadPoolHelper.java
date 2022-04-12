package com.wt.tmall.controller;

import jodd.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/12 14:04
 */
public class ThreadPoolHelper {

    public static ThreadPoolExecutor getThreadPool() {
        //线程池没有复用
        return (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }


    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            10, 50,
            2, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").get());

    public static ThreadPoolExecutor getRightThreadPool() {
        return threadPoolExecutor;
    }
}
