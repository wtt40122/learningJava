package com.wt.algorithm.query;

/**
 * @Auther: wtt
 * @Date: 2021/1/25 17:54
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arr = {1,3,5,8,4,2};
        int index = LineSearch.lineSearch(arr, 9);
        System.out.println(index);
    }
}
