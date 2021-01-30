package com.wt.algorithm.sort;

import java.util.Random;

/**
 * @Auther: wtt
 * @Date: 2021/1/29 16:11
 * @Description: 数组生成器
 */
public class ArrayGenerator {
    private ArrayGenerator() {
    }

    public static Integer[] generateRandomArray(int length, int max) {
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }

    public static Integer[] generateOrderArray(int length){
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] =i;
        }
        return arr;
    }

}
