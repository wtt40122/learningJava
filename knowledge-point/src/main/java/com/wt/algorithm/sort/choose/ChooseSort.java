package com.wt.algorithm.sort.choose;

/**
 * @Auther: wtt
 * @Date: 2021/1/25 18:04
 * @Description:
 */
public class ChooseSort {

    private ChooseSort() {
    }

    public static <E extends Comparable> void chooseSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swapData(arr, minIndex, i);
        }

    }

    private static <E> void swapData(E[] arr, int originIndex, int targetIndex) {
        E temp = arr[originIndex];
        arr[originIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }
}
