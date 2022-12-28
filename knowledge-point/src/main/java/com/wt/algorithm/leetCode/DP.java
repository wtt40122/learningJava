package com.wt.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description 动态规划问题，重要的是剪枝，记忆
 * @date 2022/11/15 10:06
 */
public class DP {

    static Map<Integer, Integer> map = new HashMap<>();

    public static int fib(int n) {
        if (n == 0 | n == 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = fib(n - 1) + fib(n - 2);
        map.put(n, result);
        return result;
    }

    public static int fib2(int n) {
        if (n == 0 | n == 1) {
            return n;
        }
        int[] dps = new int[n + 1];
        dps[0] = 0;
        dps[1] = 1;
        for (int i = 2; i <= n; i++) {
            dps[i] = dps[i - 1] + dps[i - 2];
        }
        return dps[n];
    }

    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dps = new int[n + 1];
        dps[0] = 0;
        dps[1] = 1;
        dps[2] = 2;
        for (int i = 3; i <= n; i++) {
            dps[i] = dps[i - 1] + dps[i - 2];
        }
        return dps[n];
    }

    /**
     * @return int
     * @Description 买卖股票的最佳时机
     * @Author wtt
     * @Date 2022/12/28 22:23
     * @param: [prices]
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    /**
     * @return int
     * @Description 买卖股票的最佳时机II
     * @Author wtt
     * @Date 2022/12/28 22:44
     * @param: [prices]
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    /**
     * @return int
     * @Description 买卖股票的最佳时机III
     * @Author wtt
     * @Date 2022/12/28 23:03
     * @param: [prices]
     */
    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    /**
     * @return int
     * @Description 买卖股票最佳时机IV
     * @Author wtt
     * @Date 2022/12/28 23:27
     * @param: [k, prices]
     */
    public int maxProfit4(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

    public static void main(String[] args) {
        System.out.println(fib2(2));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));

    }
}
