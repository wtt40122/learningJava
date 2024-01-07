package com.wt.algorithm.array;

/**
 * @Author: wtt
 * @Date: 2024/1/3 21:44
 * @Version: 1.0
 * @Description:
 */
public class SearchArray {
    /**
     * 暴力搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分搜索 --递归法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if (right <= left) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return binarySearch(nums, target, left, middle);
        } else {
            return binarySearch(nums, target, middle + 1, right);
        }
    }

    /**
     * 二分搜索 --循环法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, -1, 0, 3, 5, 9, 12};
        System.out.println(search3(arr, 90));
    }

}
