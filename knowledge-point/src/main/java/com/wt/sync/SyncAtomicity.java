package com.wt.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/6/24 16:06
 */
public class SyncAtomicity {
    public static void main(String[] args) {
        SyncAtomicity syncAtomicity = new SyncAtomicity();
        //synchronized修饰实例方法
//        new Thread(() -> syncAtomicity.testSYNC()).start();
//        new Thread(() -> syncAtomicity.testSYNC()).start();
        //synchronized修饰静态方法
//        new Thread(() -> SyncAtomicity.testSYNCForStatic()).start();
//        new Thread(() -> SyncAtomicity.testSYNCForStatic()).start();
        //正常方法
        new Thread(() -> syncAtomicity.test()).start();
        new Thread(() -> syncAtomicity.test()).start();
    }

    //加锁方法
    public synchronized static void testSYNCForStatic() {
        System.out.println("进入testSYNC方法>>>>>>>>>>>>>>>>>>>>>");
        try {
//模拟方法体尚未执行完毕
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //加锁方法
    public synchronized void testSYNC() {
        System.out.println("进入testSYNC方法>>>>>>>>>>>>>>>>>>>>>");
        try {
            //模拟方法体尚未执行完毕
            TimeUnit.SECONDS.sleep(6);
            System.out.println("执行完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //正常方法
    public void test() {
        System.out.println("进入test方法>>>>>>>>>>>>>>>>>>>>>");
        try {
            //模拟方法体尚未执行完毕
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
