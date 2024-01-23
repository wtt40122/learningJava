package com.wt.algorithm.other;

import java.util.Arrays;

/**
 * @author wtt
 * @version 1.0
 * @description 十大排序算法
 * @date 2024/1/23 16:27
 */
public class SortCode {

    /**
     * 选择排序
     * 每一次从当前位置后的所有元素中选择最小的元素，然后与当前位置的元素交换
     *
     * @param nums
     */
    public void chooseSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序
     * 从第一个元素开始，将后边的元素一次插入前边有序的序列中
     * 每一次插入，当前位置前边的都是有序的
     *
     * @param nums
     */
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 冒泡排序
     * 第一层控制排序的次数
     * 第二层比较每个值，把最大的值和后面交换
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortCode sortCode = new SortCode();
        int[] nums = {5, 2, 3, 1};
        sortCode.bubbleSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
