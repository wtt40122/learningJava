package com.wt.algorithm.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/10/30 15:06
 */
public class DuplicateElement {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            while (right < nums.length && right - left <= k) {
                if (map.containsKey(nums[right]) && right - map.get(nums[right]) <= k) {
                    return true;
                }
                map.put(nums[right], right);
                right++;
            }
            left++;
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() >= k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate2(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate2(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
