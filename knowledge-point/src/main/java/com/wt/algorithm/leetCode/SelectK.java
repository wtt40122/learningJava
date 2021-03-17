package com.wt.algorithm.leetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: wtt
 * @Date: 2021/3/16 10:12
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SelectK {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length-k);
    }

    private static Random random = new Random();

    private int findKthLargest(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (k == p) return nums[p];
        if (k < p) {
            return findKthLargest(nums, l, p - 1, k);
        }
        return findKthLargest(nums, p + 1, r, k);
    }

    private int partition(int[] nums, int l, int r) {
        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            while (j >= i && nums[j] > nums[l]) {
                j--;
            }
            if (i >= j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        SelectK selectK = new SelectK();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(selectK.findKthLargest(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
