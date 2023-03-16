package com.wt.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/2/10 11:33
 */
public class FutureTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.println("Main:开始执行任务");
        Future<?> future = threadPool.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main:取消任务");
        // 参数true 如果线程正在运行则进行中断处理。
        future.cancel(false);
        System.out.println("Main:isCancelled:" + future.isCancelled());
        System.out.println("Main:isDone:" + future.isDone());
        threadPool.shutdown();
        System.out.println("Main:结束执行任务");

    }
}
