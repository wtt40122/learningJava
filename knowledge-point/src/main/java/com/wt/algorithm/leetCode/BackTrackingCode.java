package com.wt.algorithm.leetCode;

import java.util.*;

/**
 * @author: wtt
 * @date: 2022/12/6 22:05
 * @description: 回溯算法
 */
public class BackTrackingCode {

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 组合问题
     * @Author wtt
     * @Date 2022/12/7 23:03
     * @param: [n, k]
     */
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
        for (int i = startIndex; i <= n - (k - result.size()) + 1; i++) {
            result.add(i);
            backTracking(n, k, i + 1, result, list);
            result.remove(result.size() - 1);
        }
    }

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 组合求和
     * @Author wtt
     * @Date 2022/12/7 23:03
     * @param: [k, n]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking3(n, k, 1, 0, new ArrayList<>(), list);
        return list;
    }

    private void backTracking3(int n, int k, int startIndex, int sum,
                               List<Integer> result, List<List<Integer>> list) {
        if (sum > n) {
            return;
        }
        if (result.size() == k) {
            if (sum == n) {
                list.add(new ArrayList<>(result));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - result.size()) + 1; i++) {
            result.add(i);
            backTracking3(n, k, i + 1, sum + i, result, list);
            result.remove(result.size() - 1);
        }
    }

    /**
     * @return java.util.List<java.lang.String>
     * @Description 电话号码组合问题
     * @Author wtt
     * @Date 2022/12/7 23:02
     * @param: [digits]
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        trackLetter(digits, 0, list, map, new StringBuilder());
        return list;
    }


    private void trackLetter(String digits, int index, List<String> list,
                             Map<Character, String> map, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        Character charStr = digits.toCharArray()[index];
        String str = map.get(charStr);
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            trackLetter(digits, index + 1, list, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 组合总和II
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTracking2(candidates, target, 0, 0, new int[candidates.length], new ArrayList(), result);
        return result;
    }

    private void backTracking2(int[] candidates, int target, int sum,
                               int startIndex, int[] used, List<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            list.add(candidates[i]);
            used[i] = 1;
            backTracking2(candidates, target, sum + candidates[i], i + 1, used, list, result);
            used[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 切割回文字符串
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        backTrackingPartition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrackingPartition(String s, int startIndex, List<String> path, List<List<String>> result) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backTrackingPartition(s, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    /**
     * 复原IP地址
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        backTrackingIp(new StringBuilder(s), 0, 0, result);
        return result;
    }

    private void backTrackingIp(StringBuilder sb, int starIndex, int positionNum, List<String> result) {
        if (positionNum == 3) {
            if (isValid(sb.toString(), starIndex, sb.toString().length() - 1)) {
                result.add(sb.toString());
            }
            return;
        }
        for (int i = starIndex; i < sb.toString().length(); i++) {
            if (isValid(sb.toString(), starIndex, i)) {
                sb.insert(i + 1, ".");
                positionNum++;
                backTrackingIp(sb, i + 2, positionNum, result);
                positionNum--;
                sb.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s, int startedIndex, int endIndex) {
        if (startedIndex > endIndex) {
            return false;
        }
        if (s.charAt(startedIndex) == '0' && startedIndex != endIndex) {
            return false;
        }
        String substring = s.substring(startedIndex, endIndex + 1);
        long value = Long.parseLong(substring);
        if (value >= 0L && value <= 255L) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BackTrackingCode code = new BackTrackingCode();
        List<String> combine = code.restoreIpAddresses("25525511135");
        combine.stream().forEach(System.out::println);
    }
}
