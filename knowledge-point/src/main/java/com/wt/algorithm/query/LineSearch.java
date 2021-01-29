package com.wt.algorithm.query;

/**
 * @Auther: wtt
 * @Date: 2021/1/25 17:52
 * @Description:
 */
public class LineSearch {

    private LineSearch() {
    }

    public static <E> int lineSearch(E[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
