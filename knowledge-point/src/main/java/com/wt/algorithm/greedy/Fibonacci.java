package com.wt.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Auther: wtt
 * @Date: 2022/4/23 23:26
 * @Description:
 */
public class Fibonacci {
    public static long iterate(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int k0 = 0, k1 = 1, k2 = 0, i = 1;
        while (i < n) {
            k2 = k0 + k1;
            k0 = k1;
            k1 = k2;
            i++;
        }
        return k2;
    }

    public static long recursion(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return recursion(n - 1) + recursion(n - 2);
    }



    void getMinCountsHelper(int total, int[] values, ArrayList<Integer> currentCounts,
                            ArrayList<ArrayList<Integer>> combinations) {
        if (0 == total) { // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
            combinations.add(new ArrayList<Integer>(currentCounts));
            return;
        }

        int valueLength = values.length;
        for (int i = 0;  i < valueLength; i ++) { // 遍历所有面值
            int currentValue = values[i];
            if (currentValue > total) { // 如果面值大于当前总额，直接跳过
                continue;
            }

            // 否则在当前面值数量组合上的对应位置加1
            ArrayList<Integer> newCounts = new ArrayList<Integer>(currentCounts);
            newCounts.set(i, newCounts.get(i)+1);
            int rest = total - currentValue;

            getMinCountsHelper(rest, values, newCounts, combinations); // 求解剩余额度所需硬币数量
        }
    }

    int getMinimumHelper(ArrayList<ArrayList<Integer>> combinations) {
        // 如果没有可用组合，返回-1
        if (0 == combinations.size()) { return -1; }

        int minCount = Integer.MAX_VALUE;
        for (ArrayList<Integer> counts : combinations) {
            int total = 0; // 求当前组合的硬币总数
            for (int count : counts) { total += count; }

            // 保留最小的
            if (total < minCount) { minCount = total; }
        }

        return minCount;
    }

    int getMinCountOfCoins() {
        int[] values = { 5, 3 }; // 硬币面值的数组
        int total = 11; // 总值

        ArrayList<Integer> initialCounts = new ArrayList<>(Collections.nCopies(values.length, 0)); // 初始值(0,0)

        ArrayList<ArrayList<Integer>> coinCombinations = new ArrayList<>(); // 存储所有组合
        getMinCountsHelper(total, values, initialCounts, coinCombinations); // 求解所有组合（不去重）

        return getMinimumHelper(coinCombinations); // 输出答案
    }


    public static void main(String[] args) {
        int n = 23;
        System.out.println(iterate(n));
        System.out.println(recursion(n));
    }
}
