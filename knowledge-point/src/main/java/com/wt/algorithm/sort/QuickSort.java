package com.wt.algorithm.sort;

import java.util.Random;

/**
 * @Auther: wtt
 * @Date: 2021/3/9 09:24
 * @Description: 快速排序
 */
public class QuickSort {
    private QuickSort() {
    }

    // 单路快速排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    static final Random random = new Random();

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, p, l);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    // 2路快速排序
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition2(arr, l, r);
        sort2(arr, l, p - 1);
        sort2(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, p, l);
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
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

    // 3路快速排序
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        sort3(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort3(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = l + random.nextInt(r - 1 + 1);
        swap(arr, p, l);
        int i = l + 1, lt = l, gt = r+1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, gt, i);
            } else {
                i++;
            }
        }
        swap(arr,l,lt);
        sort3(arr, l, lt-1);
        sort(arr, gt, r);
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("quickSort", arr);
        SortingHelper.sortTest("quickSort2", arr);
        SortingHelper.sortTest("quickSort3", arr);

        System.out.println();
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n,1);
        SortingHelper.sortTest("quickSort2", arr2);
        SortingHelper.sortTest("quickSort2", arr2);
        SortingHelper.sortTest("quickSort3", arr2);

        System.out.println();
        Integer[] arr1 = ArrayGenerator.generateOrderArray(n);
        SortingHelper.sortTest("quickSort2", arr1);
        SortingHelper.sortTest("quickSort2", arr1);
        SortingHelper.sortTest("quickSort3", arr1);
    }
}
