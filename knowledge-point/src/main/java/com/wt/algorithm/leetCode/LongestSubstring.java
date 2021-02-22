package com.wt.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wtt
 * @Date: 2021/2/14 11:55
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstring {

    private LongestSubstring() {
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(LongestSubstring.lengthOfLongestSubstring(str));
    }
}
