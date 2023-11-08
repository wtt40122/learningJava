package com.wt.learn;

/**
 * @author wtt
 * @version 1.0
 * @description 栈内存溢出
 * -XX:ThreadStackSize=1m
 * @date 2023/11/8 9:53
 */
public class Demo08 {

    public static long counter = 0;

    public static void main(String[] args) {
        work();
    }

    private static void work() {
        System.out.println("目前是第:" + (++counter) + "次调用方法");
        work();
    }
}
