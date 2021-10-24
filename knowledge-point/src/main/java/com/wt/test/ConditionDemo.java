package com.wt.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: wtt
 * @Date: 2021/5/10 09:38
 * @Description:
 */
public class ConditionDemo {
    private static int num = 1;
    private static Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        long loop = countDownLatch.getCount(); //初始化打印轮数

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    printA();
                } catch (InterruptedException e) {
                }
            }
            countDownLatch.countDown();
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    printB();
                } catch (InterruptedException e) {
                }
            }
            countDownLatch.countDown();
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    printC();
                } catch (InterruptedException e) {
                }
            }
            countDownLatch.countDown();
        }, "C").start();

        countDownLatch.await();
        System.out.println();
        System.out.println("打印完毕.........");
    }

    public static void printA() throws InterruptedException {
        lock.lock();
        if (num != 1) {
            conditionA.await();
        }
        System.out.print(Thread.currentThread().getName());
        num = 2;
        conditionB.signal();
        lock.unlock();
    }

    public static void printB() throws InterruptedException {
        lock.lock();
        if (num != 2) {
            conditionB.await();
        }
        System.out.print(Thread.currentThread().getName());
        num = 3;
        conditionC.signal();
        lock.unlock();
    }

    public static void printC() throws InterruptedException {
        lock.lock();
        if (num != 3) {
            conditionC.await();
        }
        System.out.print(Thread.currentThread().getName());
        num = 1;
        conditionA.signal();
        lock.unlock();
    }
}
