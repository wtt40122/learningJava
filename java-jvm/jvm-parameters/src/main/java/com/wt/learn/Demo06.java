package com.wt.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/11/5 17:25
 */
public class Demo06 {
    public static void main(String[] args) throws InterruptedException {
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }

    static class Data {

    }
}
