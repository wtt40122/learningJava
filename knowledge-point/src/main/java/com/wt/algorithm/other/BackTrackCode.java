package com.wt.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2024/2/1 22:13
 * @Version: 1.0
 * @Description: 回溯算法
 */
public class BackTrackCode {
    /**
     * 组合
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int index, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backtrack(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 组合总和III
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack1(k, n, 1, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack1(int k, int n, int index, int sum, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i <= 9 - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack1(k, n, i + 1, sum + i, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        BackTrackCode backTrackCode = new BackTrackCode();
        List<List<Integer>> result = backTrackCode.combinationSum3(3, 7);
        System.out.println(result);
    }
}
