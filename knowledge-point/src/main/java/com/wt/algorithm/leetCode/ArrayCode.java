package com.wt.algorithm.leetCode;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/16 13:42
 */
public class ArrayCode {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                right = middle - 1;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                right = middle;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1,0,3,5,9,12}, 0));
    }
}
