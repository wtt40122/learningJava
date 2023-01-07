package com.wt.algorithm.leetCode;

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

    public static void main(String[] args) {
        LeetCode code = new LeetCode();
        int[] nums = {8, 1, 2, 2, 3};
        code.smallerNumbersThanCurrent(nums);
    }
}
