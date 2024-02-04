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

    /**
     * 分割回文串
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack5(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack5(String s, int index, List<String> path, List<List<String>> result) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backtrack5(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 复原ip地址
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack6(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack6(String s, int index, List<String> path, List<String> result) {
        if (index >= s.length()) {
            if (path.size() == 4) {
                result.add(String.join(".", path));
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (is_valid_ip(s, index, i + 1)) {
                path.add(s.substring(index, i + 1));
                backtrack6(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean is_valid_ip(String s, int start, int end) {
        String numberStr = s.substring(start, end);
        if ((numberStr.length() > 1 && numberStr.charAt(0) == '0') || numberStr.length() > 4) {
            return false;
        }
        int number = Integer.parseInt(numberStr);
        if (number > 255) {
            return false;
        }
        return true;
    }

    /**
     * 子集问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack7(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack7(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack7(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 子集II
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack8(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack8(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack8(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 递增子序列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack9(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack9(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtrack9(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack10(nums, new ArrayList<>(), result, used);
        return result;
    }

    private void backtrack10(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            set.add(nums[i]);
            path.add(nums[i]);
            backtrack10(nums, path, result, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    /**
     * 全排列II
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack11(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack11(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            used[i] = true;
            backtrack11(nums, path, result, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        BackTrackCode backTrackCode = new BackTrackCode();
        List<List<Integer>> result = backTrackCode.permuteUnique(nums);
        System.out.println(result);
    }

}
