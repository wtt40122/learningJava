package com.wt.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wtt
 * @date: 2022/12/6 22:05
 * @description: 回溯算法
 */
public class BackTrackingCode {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    private void backTracking(int n, int k, int startIndex,
                              List<Integer> result, List<List<Integer>> list) {
        if (result.size() == k) {
            list.add(new ArrayList<>(result));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            result.add(i);
            backTracking(n, k, i + 1, result, list);
            result.remove(result.size() - 1);
        }
    }


    public static void main(String[] args) {
        BackTrackingCode code = new BackTrackingCode();
        List<List<Integer>> combine = code.combine(1, 1);
        System.out.println(combine);
    }
}
