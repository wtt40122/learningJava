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

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[slowIndex] = nums[i];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 0));
        System.out.println(removeElement1(new int[]{-1, 3, 3, 5, 9, 12, 3}, 3));
    }
}
