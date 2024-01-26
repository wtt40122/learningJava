package com.wt.sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wtt
 * @version 1.0
 * @description cas中拿到value的内存地址，并不是值，每次自旋的时候都会通过这个内存地址去拿值，所以每次自旋的时候都会拿到最新的值
 * @date 2024/1/26 11:13
 */
public class CasTest {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(3);
        new Thread(() -> {
            int i = count.addAndGet(3);
            System.out.println(i);
        }).start();
        new Thread(() -> {
            int i = count.addAndGet(4);
            System.out.println(i);
        }).start();
        System.out.println(count.get());

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
