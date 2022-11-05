package com.wt.algorithm.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/10/29 20:34
 */
public class LengthStr {

    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        for (int i = 0; i < str.toCharArray().length; i++) {
            for (int j = i + 1; j < str.toCharArray().length; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    int length = j - i;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    break;
                }
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstrings(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(left, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstrings2(String str) {
        int maxLength = 0;
        int left = 0, right = 0;
        HashSet hashSet = new HashSet();
        while (right < str.length()) {
            if (hashSet.contains(str.charAt(right))) {
                hashSet.remove(str.charAt(left));
                left++;
            } else {
                hashSet.add(str.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength, hashSet.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstrings2("aaaa"));
//        System.out.println(lengthOfLongestSubstring("abca"));
//        System.out.println(lengthOfLongestSubstring("abcavb"));
//        System.out.println(lengthOfLongestSubstring(""));
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("a"));
//        System.out.println(lengthOfLongestSubstring("au"));
//        System.out.println(lengthOfLongestSubstring("aucd"));
//        System.out.println(lengthOfLongestSubstrings2("abcabcbb"));
//        System.out.println(lengthOfLongestSubstrings2("abba"));
        System.out.println(lengthOfLongestSubstrings2("pwwkew"));
        System.out.println(lengthOfLongestSubstrings2("dvdf"));
    }
}
