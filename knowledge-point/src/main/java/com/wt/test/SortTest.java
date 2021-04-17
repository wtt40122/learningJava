package com.wt.test;

import java.util.Arrays;
import java.util.Random;

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

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (arr[i] < arr[j]) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (r - l <= 0)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p);
        quickSort(arr, p + 1, r);
    }

    static Random random = new Random();

    private static int partition(int[] arr, int l, int r) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, p, l);
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] <= arr[l]) {
                i++;
            }
            while (j >= i && arr[j] >= arr[l]) {
                j--;
            }
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
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
//        bubbleSort(arr);
//        mergeSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
