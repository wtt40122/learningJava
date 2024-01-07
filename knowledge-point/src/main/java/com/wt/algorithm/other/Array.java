package com.wt.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wtt
 * @Date: 2024/1/4 21:56
 * @Version: 1.0
 * @Description:
 */
public class Array {
    /**
     * 移除元素--暴力解法
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     * 移除元素--快慢指针
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 移除重复元素
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public int[] sortedSquares1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[k] = nums[left] * nums[left];
                left++;
            } else {
                result[k] = nums[right] * nums[right];
                right--;
            }
            k--;
        }
        return result;
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                if (map.get(fruits[j]) > 1) {
                    map.put(fruits[j], map.get(fruits[j]) - 1);
                } else {
                    map.remove(fruits[j]);
                }
                j++;
            }
            count = Math.max(count, i - j + 1);
        }
        return count;
    }


    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0;
        String res = "";
        Integer count = Integer.MAX_VALUE;
        for (int j = 0; j < s.length(); j++) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            while (containsMap(sMap, tMap)) {
                if (j - i + 1 < count) {
                    count = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                if (sMap.get(s.charAt(i)) > 1) {
                    sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                } else {
                    sMap.remove(s.charAt(i));
                }
                i++;
            }
        }
        return res;
    }

    private static Boolean containsMap(Map<Character, Integer> originMap,
                                       Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (originMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] data = {1, 1, 2};
//        System.out.println(removeDuplicates(data));
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

    }
}
