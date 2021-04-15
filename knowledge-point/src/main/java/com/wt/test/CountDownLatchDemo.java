package com.wt.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: wtt
 * @Date: 2021/4/14 14:43
 * @Description:
 * ①. CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞
 * <p>
 * ②. 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)
 * <p>
 * ③. 计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(CountryEnum.values().length);
        for (int i = 1; i <= CountryEnum.values().length; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "**国,被灭");
                countDownLatch.countDown();
            }, CountryEnum.getCountryEnum(i).getRetMessage()).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t" + "**秦国一统山河");
    }
}
