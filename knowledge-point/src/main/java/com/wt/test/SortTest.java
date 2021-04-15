package com.wt.test;

import java.util.Arrays;

/**
 * @Auther: wtt
 * @Date: 2021/4/15 09:55
 * @Description:
 */
public class SortTest {

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            for (; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            System.out.println("maxIndex" + maxIndex);
            swap(arr, i, maxIndex);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5, 9, 0};
//        insertionSort(arr);
//        selectionSort(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
