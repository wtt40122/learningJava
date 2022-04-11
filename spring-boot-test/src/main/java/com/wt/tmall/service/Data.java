package com.wt.tmall.service;

import lombok.Getter;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/11 20:14
 */
public class Data {
    @Getter
    private static int counter = 0;
    private static Object locker = new Object();

    public static int reset() {
        counter = 0;
        return counter;
    }

    public void wrong() {
        synchronized (locker) {
            counter++;
        }
    }
}
