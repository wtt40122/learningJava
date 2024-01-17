package com.wt.algorithm.other;

import java.util.Arrays;

/**
 * @Author: wtt
 * @Date: 2024/1/4 22:51
 * @Version: 1.0
 * @Description:
 */
public class StringCode {
    /**
     * 给定 s 和 t 两个字符串，判断它们是否是同构的。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public static int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                String[] abs = s.split("AB");
                String str = "";
                for (String ab : abs) {
                    if (!"".equals(ab)) {
                        str += ab;
                    }
                }
                s = str;
            }
            if (s.contains("CD")) {
                String[] abs = s.split("CD");
                String str = "";
                for (String ab : abs) {
                    if (!"".equals(ab)) {
                        str += ab;
                    }
                }
                s = str;
            }
        }
        return s.length();
    }

    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 反转字符串2
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i, right = Math.min(i + k, s.length()) - 1;
            while (left < right) {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    /**
     * 反转字符串3
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right;
        for (right = 0; right < chars.length; right++) {
            if (s.charAt(right) == ' ' || right == chars.length - 1) {
                int i = left, j = right == chars.length - 1 ? right : right - 1;
                while (i < j) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                }
                left = right + 1;
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}

