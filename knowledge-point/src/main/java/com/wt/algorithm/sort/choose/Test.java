package com.wt.algorithm.sort.choose;

import java.util.Arrays;

/**
 * @Auther: wtt
 * @Date: 2021/1/25 18:55
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arr = {1,3,5,8,4,2};
        ChooseSort.chooseSort(arr);
        System.out.print(Arrays.toString(arr));

    }
}
