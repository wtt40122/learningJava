package com.wt.algorithm.sort;

/**
 * @Auther: wtt
 * @Date: 2021/1/30 11:21
 * @Description:
 */
public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        if ("SelectionSort".equalsIgnoreCase(sortName)) {
            SelectionSort.sort(arr);
        }
        if("InsertionSort".equalsIgnoreCase(sortName)){
            InsertionSort.sort(arr);
        }
        if("InsertionSort1".equalsIgnoreCase(sortName)){
            InsertionSort.sort1(arr);
        }
        if("BubbleSort".equalsIgnoreCase(sortName)){
            BubbleSort.sort(arr);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSort(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(String.format("%s, n=%d : %f s", sortName, arr.length, time));
    }
}
