package com.wt.algorithm.sort;

/**
 * @Auther: wtt
 * @Date: 2021/1/29 14:42
 * @Description: 插入排序
 */
public class InsertSort {

    private InsertSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swapData(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort1(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swapData(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i; j - 1 > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
            }
            swapData(arr, i, j);
        }
    }


    private static <E> void swapData(E[] arr, int originIndex, int targetIndex) {
        E temp = arr[originIndex];
        arr[originIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }
}
