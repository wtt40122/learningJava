package com.wt.algorithm.dachangxueyuan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wtt
 * @date: 2022/7/23 16:16
 * @description: 2数求和
 */
public class TwoNumSum {

    public static int[] twoNumSum1(int[] array, int target) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoNumSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (indexMap.containsKey(temp)) {
                return new int[]{indexMap.get(temp), i};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int[] ints = twoNumSum(arr, 6);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
