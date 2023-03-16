package com.wt.test;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/2/10 11:34
 */
public class Task implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("执行中...");
            // 用于取消时，可被中断。(sleep遇到中断标志会抛出InterruptedException异常。从而结束方法）
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*
		//第二种写法
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("执行中...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //InterruptedException会清除中断状态，在此处进行再次中断处理即可。
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName()+":线程被中断啦");
            return null;
		*/
        }

    }
}
