package com.wt.algorithm.sort;

/**
 * @Auther: wtt
 * @Date: 2021/1/25 18:04
 * @Description: 选择排序
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
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

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort",arr);
        }
    }
}
