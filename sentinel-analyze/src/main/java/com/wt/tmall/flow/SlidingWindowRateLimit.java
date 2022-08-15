package com.wt.tmall.flow;

import lombok.Data;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/15 10:05
 */
public class SlidingWindowRateLimit implements RateLimit, Runnable {
    /**
     * 阈值
     */
    private Integer limitCount;
    /**
     * 通过的请求数
     */
    private AtomicInteger passCount;
    /**
     * 窗口数
     */
    private Integer windowSize;
    /**
     * 每个窗口时间间隔大小
     */
    private long windowPeriod;
    private TimeUnit timeUnit;

    private Window[] windows;
    private volatile Integer windowIndex = 0;

    private Lock lock = new ReentrantLock();

    public SlidingWindowRateLimit(Integer limitCount) {
        // 默认qps，窗口5
        this(limitCount, 5, 200, TimeUnit.MILLISECONDS);
    }

    public SlidingWindowRateLimit(Integer limitCount, Integer windowSize, long windowPeriod, TimeUnit timeUnit) {
        this.limitCount = limitCount;
        this.windowSize = windowSize;
        this.windowPeriod = windowPeriod;
        this.timeUnit = timeUnit;
        this.passCount = new AtomicInteger(0);
        this.initWindow();
        this.startResetTask();
    }

    private void initWindow() {
        windows = new Window[windowSize];
        for (int i = 0; i < windows.length; i++) {
            windows[i] = new Window();
        }
    }

    private ScheduledExecutorService scheduledExecutorService;

    private void startResetTask() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this, windowPeriod, windowPeriod, timeUnit);
    }

    @Override
    public boolean canPass() throws BlockException {
        lock.lock();
        try {
            if (passCount.get() > limitCount) {
                throw new BlockException();
            }
            windows[windowIndex].passCount.incrementAndGet();
            passCount.incrementAndGet();
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public void run() {
        // 获取当前窗口索引
        Integer curIndex = (windowIndex + 1) % windowSize;
        //重置当前窗口索引通过数量，并获取上一次通过数量
        Integer count = windows[curIndex].passCount.getAndSet(0);
        windowIndex = curIndex;
        //总通过数量 减去 当前窗口上次通过数量
        passCount.addAndGet(-count);
    }

    @Data
    class Window {
        private AtomicInteger passCount;

        public Window() {
            this.passCount = new AtomicInteger(0);
        }
    }

    public static void main(String[] args) throws BlockException {
        SlidingWindowRateLimit slidingWindowRateLimit = new SlidingWindowRateLimit(100);
        for (int i = 1; i < 10000000; i++) {
//            Thread.sleep(10);
            if (slidingWindowRateLimit.canPass()) {
                System.out.println("我是第" + i + "个请求");
            }
        }
    }
}
