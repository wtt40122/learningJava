package com.wt.algorithm.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode {
    /**
     * 有多少小于当前数字的数字
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCount = new int[nums.length];
        for (int i = 0; i < numsCount.length; i++) {
            int count = 0;
            int target = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < target) {
                    count++;
                }
            }
            numsCount[i] = count;
        }
        return numsCount;
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }

    /**
     * 独一无二的出现次数
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            set.add(value);
        }
        return set.size() == map.size();
    }

    public static void main(String[] args) {
        LeetCode code = new LeetCode();
        int[] nums = {0, 3, 2, 1};
        code.smallerNumbersThanCurrent(nums);
        code.validMountainArray(nums);
    }
}
