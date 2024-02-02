package com.wt.algorithm.other;

import java.util.*;

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

    /**
     * 电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack2(map, digits, 0, "", result);
        return result;
    }

    private void backtrack2(Map<Integer, String> map, String digits, Integer index,
                            String str, List<String> result) {
        if (index == digits.length()) {
            result.add(str);
            return;
        }
        String strPer = map.get(digits.charAt(index) - '0');
        for (int i = 0; i < strPer.length(); i++) {
            backtrack2(map, digits, index + 1, str + strPer.charAt(i), result);
        }
    }

    /**
     * 组合总和
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        backtrack3(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack3(int[] candidates, int target, int index, int sum,
                            List<Integer> path, List<List<Integer>> result) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backtrack3(candidates, target, i, sum + candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backtrack4(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack4(int[] candidates, int target, int index,
                            int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backtrack4(candidates, target, i + 1, sum + candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        BackTrackCode backTrackCode = new BackTrackCode();
        List<List<Integer>> result = backTrackCode.combinationSum(candidates, 7);
        System.out.println(result);
    }

}
