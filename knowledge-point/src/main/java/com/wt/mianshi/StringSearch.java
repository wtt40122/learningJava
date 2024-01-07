package com.wt.mianshi;

/**
 * @Author: wtt
 * @Date: 2024/1/1 13:10
 * @Version: 1.0
 * @Description: 字符串搜索，B是否在A中存在
 */
public class StringSearch {

    public static int strSearch(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 > length1) {
            return -1;
        }
        for (int i = 0; i <= length1 - length2; i++) {
            int j;
            for (j = 0; j < length2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "tsa";
        System.out.println(strSearch(haystack, needle));
    }
}
