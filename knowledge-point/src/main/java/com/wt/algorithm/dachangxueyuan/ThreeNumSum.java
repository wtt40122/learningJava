package com.wt.algorithm.dachangxueyuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wtt
 * @date: 2022/7/23 16:35
 * @description: 3数求和
 */
public class ThreeNumSum {
    /**
     * 没考虑去重，不可用
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return lists.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 双指针法(完美)
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lp = i + 1;
            int rp = n - 1;
            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp++;
                    rp--;
                    while (lp < rp && nums[lp] == nums[lp -1]) lp++;
                    while (lp < rp && nums[rp] == nums[rp + 1]) rp--;
                } else if (sum > 0) {
                    rp--;
                } else {
                    lp++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> lists = threeSum(nums);
        lists.stream().forEach(System.out::println);
    }
}
