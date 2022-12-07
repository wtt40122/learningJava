package com.wt.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void main(String[] args) {
        BackTrackingCode code = new BackTrackingCode();
        List<String> combine = code.letterCombinations("23");
        combine.stream().forEach(System.out::println);
    }
}
