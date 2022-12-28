package com.wt.algorithm.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/10/30 11:31
 */
public class Str {

    public static List<String> letterCasePermutation(String s) {
        Set<String> hashSet = new HashSet();
        int right = 0;
        int left = 0;
        while (right < s.length()) {

            while (left < right) {


                left++;
            }
            String temp = String.valueOf(s.charAt(right));
            hashSet.add(s.substring(0, right) + temp.toLowerCase() + s.substring(right + 1));
            hashSet.add(s.substring(0, right) + temp.toUpperCase() + s.substring(right + 1));
            hashSet.add(s.substring(0, right) + temp + s.substring(right + 1));
            right++;
        }
        return hashSet.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = letterCasePermutation("a1b2");
        list.stream().forEach(System.out::println);
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
