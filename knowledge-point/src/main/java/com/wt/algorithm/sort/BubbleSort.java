package com.wt.algorithm.sort;

/**
 * @Auther: wtt
 * @Date: 2021/1/29 17:10
 * @Description: 冒泡排序
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swapData(arr, j, j + 1);
                }
            }
        }
    }

    private static <E> void swapData(E[] arr, int originIndex, int targetIndex) {
        E temp = arr[originIndex];
        arr[originIndex] = arr[targetIndex];
        arr[targetIndex] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("BubbleSort",arr);
        }
    }
}
