package com.wt.tmall.flow;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wtt
 * @version 1.0
 * @description 计数器限流
 * @date 2022/8/15 9:46
 */
public class CounterRateLimit implements RateLimit, Runnable {
    /**
     * 阈值
     */
    private Integer limitCount;
    /**
     * 通过请求数
     */
    private AtomicInteger passCount;
    /**
     * 统计时间间隔
     */
    private long period;
    private TimeUnit timeUnit;
    private ScheduledExecutorService scheduledExecutorService;

    public CounterRateLimit(Integer limitCount) {
        this(limitCount, 1000, TimeUnit.MILLISECONDS);
    }

    public CounterRateLimit(Integer limitCount, long period, TimeUnit timeUnit) {
        this.limitCount = limitCount;
        this.passCount = new AtomicInteger(1);
        this.period = period;
        this.timeUnit = timeUnit;
        this.startResetTask();
    }

    @Override
    public boolean canPass() throws BlockException {
        if (passCount.incrementAndGet() > limitCount) {
            throw new BlockException();
        }
        return true;
    }

    private void startResetTask() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this, 0, period, timeUnit);
    }

    @Override
    public void run() {
        passCount.set(1);
    }

    public static void main(String[] args) throws InterruptedException, BlockException {
        CounterRateLimit counterRateLimit = new CounterRateLimit(10, 2000, TimeUnit.MILLISECONDS);
        for (int i = 1; i < 10000000; i++) {
            Thread.sleep(200L);
            if (counterRateLimit.canPass()) {
                System.out.println("我是第" + i + "个请求");
            }
        }
    }
}
