package com.wt.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 堆内存溢出
 *  -Xms10m -Xmx10m
 * @date 2023/11/8 10:01
 */
public class Demo09 {
    public static void main(String[] args) {
        int count = 0;
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
            System.out.println("当前创建了第:" + (++count) + "个对象");
        }
    }
}
