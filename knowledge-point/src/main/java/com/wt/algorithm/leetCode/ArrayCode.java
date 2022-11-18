package com.wt.algorithm.leetCode;

import java.util.Arrays;

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

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortedSquaresDoublePoint(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[k] = nums[right] * nums[right];
                right--;
            } else {
                result[k] = nums[left] * nums[left];
                left++;
            }
            k--;
        }
        int succeed;
        return result;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == target) {
                        result[1] = j;
                    }
                }
                break;
            }
        }
        return result;
    }

    public static int[] searchRangeBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                result[0] = middle;
                result[1] = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 0));
//        System.out.println(removeElement1(new int[]{-1, 3, 3, 5, 9, 12, 3}, 3));
//        Arrays.stream(sortedSquaresDoublePoint(new int[]{-4, -1, 0, 3, 10})).forEach(System.out::println);
//        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
//        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        Arrays.stream(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::println);
    }
}
