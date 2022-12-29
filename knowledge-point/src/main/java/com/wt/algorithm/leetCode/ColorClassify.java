package com.wt.algorithm.leetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: wtt
 * @Date: 2021/3/15 12:32
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ColorClassify {

    private static Random random = new Random();

    private ColorClassify() {
    }

    public static void classify(int[] nums) {
        int zero = -1, i = 0, two = nums.length;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 1, 2, 0};
        ColorClassify.classify(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int i = -1, k = 0, j = nums.length;
        while (k < j) {
            if (nums[k] == 0) {
                i++;
                swap(nums, i, k);
                k++;
            } else if (nums[k] == 1) {
                k++;
            } else {
                j--;
                swap(nums, k, j);
            }
        }
    }
}
