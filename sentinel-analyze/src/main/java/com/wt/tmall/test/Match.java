package com.wt.tmall.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wtt
 * @date: 2022/5/24 13:08
 * @description:
 */
@Slf4j
public class Match {

    static class Task implements Runnable {

        private String value;

        public Task(String value) {
            this.value = value;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long start = System.currentTimeMillis();
                List<String> ids = Arrays.stream(value.split(",")).collect(Collectors.toList());

                boolean exist = ids.contains("4029000");
                log.info("exist:" + exist + ",time:" + (System.currentTimeMillis() - start));
            }

        }
    }

    public static void main(String[] args) {
        StringBuilder value = new StringBuilder();
        for (int i = 4000000; i <= 4029000; i++) {
            value.append(i).append(",");
        }
        String strValue = value.toString();
        System.out.println(strValue.length());
        for (int i = 0; i < 200; i++) {
            new Thread(new Task(strValue)).start();
        }
    }
}
