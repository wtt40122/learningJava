package com.wt.algorithm.other;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: wtt
 * @Date: 2021/1/27 09:46
 * @Description:
 */
public class ThreadLocalTest {
    static ThreadLocal threadLocal = new ThreadLocal();
    static Integer MOCK_MAX = 10000;
    static Integer THREAD_MAX = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
        for (int i = 0; i < THREAD_MAX; i++) {
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalTest().getList());
                System.out.println(Thread.currentThread().getName());
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    List getList() {
        List list = new ArrayList();
        for (int i = 0; i < MOCK_MAX; i++) {
            list.add("Version：JDK 8");
            list.add("ThreadLocal");
            list.add("Author：老王");
            list.add("DateTime：" + LocalDateTime.now());
            list.add("Test：ThreadLocal OOM");
        }
        return list;
    }
}
