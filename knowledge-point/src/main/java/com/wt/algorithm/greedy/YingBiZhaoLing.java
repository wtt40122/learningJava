package com.wt.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wtt
 * @Date: 2022/4/12 23:45
 * @Description:
 */
public class YingBiZhaoLing {

    public static int getMinCoinCountHelper(int total, int[] values) {
        int rest = total;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            int currentCount = rest / values[i];
            rest -= currentCount * values[i];
            count += currentCount;
            if (rest == 0) {
                return count;
            }
        }
        return -1;
    }


    int getMinCoinCountOfValue(int total, int[] values, int valueIndex) {
        int valueCount = values.length;
        if (valueIndex == valueCount) {
            return Integer.MAX_VALUE;
        }

        int minResult = Integer.MAX_VALUE;
        int currentValue = values[valueIndex];
        int maxCount = total / currentValue;

        for (int count = maxCount; count >= 0; count--) {
            int rest = total - count * currentValue;

            // 如果rest为0，表示余额已除尽，组合完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }

            // 否则尝试用剩余面值求当前余额的硬币总数
            int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);

            // 如果后续没有可用组合
            if (restCount == Integer.MAX_VALUE) {
                // 如果当前面值已经为0，返回-1表示尝试失败
                if (count == 0) {
                    break;
                }
                // 否则尝试把当前面值-1
                continue;
            }

            minResult = Math.min(minResult, count + restCount);
        }

        return minResult;
    }

    int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;

        if (k == valueCount) {
            return Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
        }

        for (int i = k; i <= valueCount - 1; i++) {
            // k位置已经排列好
            int t = values[k];
            values[k] = values[i];
            values[i] = t;
            minCount = Math.min(minCount, getMinCoinCountLoop(total, values, k + 1)); // 考虑后一位

            // 回溯
            t = values[k];
            values[k] = values[i];
            values[i] = t;
        }

        return minCount;
    }

    int getMinCoinCountOfValue() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价
        int minCoin = getMinCoinCountLoop(total, values, 0);

        return (minCoin == Integer.MAX_VALUE) ? -1 : minCoin;  // 输出答案
    }

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 组合总和
     * @Author wtt
     * @Date 2022/12/8 22:22
     * @param: [candidates, target]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        backTrackingSum(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrackingSum(int[] candidates, int target, int startIndex,
                                 int sum, List<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            backTrackingSum(candidates, target, i, sum, list, result);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 组合总和2
     * @Author wtt
     * @Date 2022/12/8 22:38
     * @param: [candidates, target]
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
    }

    public static void main(String[] args) {
        int[] values = {5, 3};
        int total = 13;
//        int minCoinCountHelper = getMinCoinCountHelper(total, values);
        YingBiZhaoLing yingBiZhaoLing = new YingBiZhaoLing();
        int minCoin = yingBiZhaoLing.getMinCoinCountOfValue(total, values, 0);
        System.out.println(minCoin);
    }
}
