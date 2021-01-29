package com.wt.algorithm.sort;

import java.util.Random;

/**
 * @Auther: wtt
 * @Date: 2021/1/29 16:11
 * @Description:
 */
public class Generator {
    private Generator() {
    }

    public static int[] generatorArray(int length, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(max);
        }
        return arr;
    }

    public static <E extends Comparable<E>> void testSort(String sortName,E[] arr){
        if("ChooseSort".equalsIgnoreCase(sortName)){
            ChooseSort.sort(arr);
        }
    }
}
