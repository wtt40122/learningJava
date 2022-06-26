package com.wt.sync;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/6/24 16:02
 */
public class SyncVisibility {
    private static Object object = new Object();
    // 创建共享变量flag
    private static boolean flag = true; //volatile也可以解决问题

    public static void main(String[] args) throws InterruptedException {
        // 创建1 不断读取共享变量
        new Thread(() -> {
            while (flag) {
    // System.out.println(">>>>>"+true);//解决可见性
    //解决可见性
             synchronized (object) {
                 System.out.println("哈哈");
                }
            }
        }).start();
        Thread.sleep(2000);
        // 线程2 修改共享变量
        new Thread(() -> {
            flag = false;
            System.out.println("线程修改了变量的值为false");
        }).start();
    }
}
