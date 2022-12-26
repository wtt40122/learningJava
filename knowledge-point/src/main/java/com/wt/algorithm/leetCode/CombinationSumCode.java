package com.wt.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 组合总和相关题目
 * @date 2022/12/25 16:30
 */
public class CombinationSumCode {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        backTracking(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking(int[] candidates, int target, int startIndex, int sum,
                              List<Integer> path, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, i, sum, path, result);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTracking2(candidates, target, 0, 0, new ArrayList<>(), result, new int[candidates.length]);
        return result;
    }

    private void backTracking2(int[] candidates, int target, int startIndex, int sum,
                               List<Integer> path, List<List<Integer>> result, int[] used) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = 1;
            backTracking2(candidates, target, i + 1, sum, path, result, used);
            used[i] = 0;
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        backTracking3(k, n, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracking3(int k, int n, int startIndex, int sum,
                               List<Integer> path, List<List<Integer>> result) {
        if (path.size() > k) {
            return;
        }
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTracking3(k, n, i + 1, sum, path, result);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void combine(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            combine(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking4(nums, target, 0, new ArrayList<>(), result);
        return result.size();
    }

    private void backTracking4(int[] nums, int target, int sum,
                               List<Integer> path, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            backTracking4(nums, target, sum, path, result);
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumCode code = new CombinationSumCode();
        int[] nums = new int[]{4, 2, 1};
        int target = 32;
        System.out.println(code.combinationSum4(nums, target));
    }
}
