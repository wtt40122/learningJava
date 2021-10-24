package com.wt.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: wtt
 * @Date: 2021/5/8 20:49
 * @Description:
 */
public class MultThreadPrint {

    private static Thread thread1, thread2, thread3;

    public static void main(String[] args) {

        thread1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 1) {
                    System.out.println(i);
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
            }
        });

        thread2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 2) {
                    LockSupport.park();
                    System.out.println(i);
                    LockSupport.unpark(thread3);
                }
            }
        });

        thread3 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0) {
                    LockSupport.park();
                    System.out.println(i);
                    LockSupport.unpark(thread1);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
