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

    public static void main(String[] args) {
        System.out.println(fib2(2));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));

    }
}
