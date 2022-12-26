package com.wt.algorithm.leetCode;

/**
 * @author wtt
 * @version 1.0
 * @description 背包问题
 * @date 2022/12/26 11:05
 */
public class BagCode {

    public int bag(int[] weights, int[] values, int bagCapacity) {
        int goods = weights.length;
        int[][] dp = new int[goods][bagCapacity + 1];
        for (int j = weights[0]; j <= bagCapacity; j++) {
            dp[0][j] = values[0];
        }
        for (int i = 1; i < goods; i++) {
            for (int j = 1; j <= bagCapacity; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagCapacity; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[goods - 1][bagCapacity];
    }

    public int bagPro(int[] weights, int[] values, int bagCapacity) {
        int[] dp = new int[bagCapacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = bagCapacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                System.out.print(dp[j] + "\t");
            }
            System.out.println("\n");
        }
//        for (int j = bagCapacity; j >= 0; j--) {
//            for (int i = 0; i < weights.length; i++) {
//                if (j < weights[i]) {
//                    dp[j] = dp[j];
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
//                }
//                System.out.print(dp[j] + "\t");
//            }
//            System.out.println("\n");
//        }
        for (int j = 0; j <= bagCapacity; j++) {
            System.out.print(dp[j] + " ");
        }
        return dp[bagCapacity];
    }


    public static void main(String[] args) {
        BagCode bagCode = new BagCode();
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagCapacity = 4;
        bagCode.bagPro(weights, values, bagCapacity);
    }
}
