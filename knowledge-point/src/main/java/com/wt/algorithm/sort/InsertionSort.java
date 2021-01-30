package com.wt.algorithm.sort;

import java.util.Arrays;

/**
 * @Auther: wtt
 * @Date: 2021/1/29 14:42
 * @Description: 插入排序
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j - 1 >= 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swapData(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swapData(arr, j, j - 1);
            }
        }
    }
    /**
     *  插入排序优化版
     */
    public static <E extends Comparable<E>> void sort1(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    private static <E> void swapData(E[] arr, int originIndex, int targetIndex) {
        E temp = arr[originIndex];
        arr[originIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] copyArr = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSort1", copyArr);
        }
    }
}
