package com.wt.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: wtt
 * @Date: 2021/5/10 09:54
 * @Description:
 */
public class PrintDemo {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        int runCount = 4;
        ThreadTest t1 = new ThreadTest(count, "A", 0, runCount);
        ThreadTest t2 = new ThreadTest(count, "B", 1, runCount);
        ThreadTest t3 = new ThreadTest(count, "C", 2, runCount);
        ThreadTest t4 = new ThreadTest(count, "D", 3, runCount);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    public static class ThreadTest extends Thread {
        private AtomicInteger count;
        private String word = null;
        private int order;
        private int runCount;

        public ThreadTest(AtomicInteger count, String word, int order, int runCount) {
            this.count = count;
            this.word = word;
            this.order = order;
            this.runCount = runCount;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (count) {
                    if (count.get() % runCount == order) {
                        System.out.println(word + "," + count.get());
                        count.getAndAdd(1);
                        count.notifyAll();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            count.wait();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
