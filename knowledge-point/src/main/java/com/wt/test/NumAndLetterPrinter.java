package com.wt.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: wtt
 * @Date: 2021/5/9 18:15
 * @Description:
 */
public class NumAndLetterPrinter {
    private static Thread numThread, letterThread;

    public static void main(String[] args) {
        letterThread = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                LockSupport.unpark(numThread);
                LockSupport.park();
            }
        }, "letterThread");

        numThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.park();
                LockSupport.unpark(letterThread);
            }
        }, "numThread");
        numThread.start();
        letterThread.start();
    }
}
