package com.wt.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/28 0:09
 */
public class Sort {
    /**
     * 快速排序
     *
     * @param nums  数据
     * @param left  左边界
     * @param right 有边界   左闭右闭
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = nums[left];
        // 5, 3, 7, 2, 9, 0, 3
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            while (i < j && nums[i] <= temp) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 3, 7, 2, 9, 0, 3};
//        quickSort(nums, 0, nums.length - 1);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }

        List<String> stringList = Lists.newArrayList("10.93.1.38", "10.93.1.43", "10.93.16.137", "10.93.16.163","10.93.1.35", "10.93.1.38", "10.93.1.43", "10.93.16.137", "10.93.16.163", "10.93.1.41", "10.93.16.127",
                "10.93.1.15", "10.93.1.47", "10.93.16.134", "10.93.16.148","10.93.1.34", "10.93.1.35", "10.93.1.7", "10.93.16.121", "10.93.16.161",
                "10.93.224.7", "10.93.228.5","10.93.1.21", "10.93.16.123","10.93.1.19", "10.93.16.145", "10.93.1.11", "10.93.16.119", "10.93.1.16", "10.93.16.132",
                "10.93.224.7", "10.93.228.5","10.93.1.15", "10.93.16.148","10.93.16.171", "10.93.1.31", "10.93.16.171", "10.93.1.31");
        stringList.stream().distinct().forEach(System.out::println);
    }
}
