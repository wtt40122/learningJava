package com.wt.pattern.proxy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: wtt
 * @Date: 2021/2/23 14:22
 * @Description:
 */
public class WoodTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try{

        }finally {
            reentrantLock.unlock();
        }

        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println("------------");

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
