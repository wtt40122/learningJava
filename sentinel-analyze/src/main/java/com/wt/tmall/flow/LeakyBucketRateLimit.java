package com.wt.tmall.flow;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wtt
 * @version 1.0
 * @description 漏桶算法
 * @date 2022/8/15 10:31
 */
public class LeakyBucketRateLimit implements RateLimit, Runnable {
    /**
     * 出口限制qps
     */
    private Integer limitSecond;
    /**
     * 漏桶队列
     */
    private BlockingQueue<Thread> leakyBucket;

    private ScheduledExecutorService scheduledExecutorService;

    public LeakyBucketRateLimit(Integer bucketSize, Integer limitSecond) {
        this.limitSecond = limitSecond;
        this.leakyBucket = new LinkedBlockingDeque<>(bucketSize);

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        long interval = (1000 * 1000 * 1000) / limitSecond;//周期秒。TimeUnit.NANOSECONDS（毫微秒，1秒=1000*1000*1000毫微秒
        scheduledExecutorService.scheduleAtFixedRate(this, 0, interval, TimeUnit.NANOSECONDS);
    }

    @Override
    public boolean canPass() throws BlockException {
        if (leakyBucket.remainingCapacity() == 0) {
            throw new BlockException();
        }
        leakyBucket.offer(Thread.currentThread());
        LockSupport.park();
        return true;
    }

    @Override
    public void run() {
        Thread thread = leakyBucket.poll();
        if (Objects.nonNull(thread)) {
            LockSupport.unpark(thread);
        }
    }

    public static void main(String[] args) throws BlockException, InterruptedException {
        LeakyBucketRateLimit leakyBucketRateLimit = new LeakyBucketRateLimit(100, 10);
        for (int i = 1; i < 10000000; i++) {
            if (leakyBucketRateLimit.canPass()) {
                System.out.println("我是第" + i + "个请求");
            }
        }
    }

}
