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

    public static String reverseWords2(String s) {
        String[] res = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            if (!"".equals(res[i])) {
                sb.append(res[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        if (next[s.length() - 1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 最长回文字符串--暴力解法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (isPalindrome(str) && str.length() > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String longestPalindrome1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = palindromeStr(s, i, i);
            String str2 = palindromeStr(s, i, i + 1);
            if (str1.length() > res.length()) {
                res = str1;
            }
            if (str2.length() > res.length()) {
                res = str2;
            }
        }
        return res;

    }

    private static String palindromeStr(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
//        System.out.println(reverseWords2("  hello world  "));
        System.out.println(longestPalindrome1("vyzonecajxxdvswhftixmzgjbfoeilbnchqmdgoxfmkkkkcqguavfozmplhzgothrwpukzgkctdacbxefrzrmbgwwrrhpcvqwvgwgknyrtxxoligsqpbqoucltakbkywwssyodzydsjxeuvgiqqitkfkqnxsfflgbjvbxdrworsdkowtkgabnszgsmgytupybdclmmsmougfendwvzarfdfbixjnlxvevqfoohcgrrysofifdfulygrmkwpimduzzluojeqixdtcxhcqnfsdbunmhsglhiplgbhrqrrrprffjfradvbifxxhoqylkejyprxdtianietnjumltxywfowopghurofvwtxvaxtqnjbzwvljjwfmmlhixogwwyaoysvrpgfymyqjschhqcwvytkreirdxfapaomayebhkzxgmlthoxialmtnilfopvhhqlocytyrtpfmpgqakdbrsteurcpfvruicuxzukfpwjwgnuaaungwjwpfkuzxuciurvfpcruetsrbdkaqgpmfptrytycolqhhvpoflintmlaixohtlmgxzkhbeyamoapafxdrierktyvwcqhhcsjqymyfgprvsyoaywwgoxihlmmfwjjlvwzbjnqtxavxtwvforuhgpowofwyxtlmujnteinaitdxrpyjeklyqohxxfibvdarfjffrprrrqrhbglpihlgshmnubdsfnqchxctdxiqejoulzzudmipwkmrgylufdfifosyrrgchoofqvevxlnjxibfdfrazvwdnefguomsmmlcdbyputygmsgzsnbagktwokdsrowrdxbvjbglffsxnqkfktiqqigvuexjsdyzdoysswwykbkatlcuoqbpqsgiloxxtrynkgwgvwqvcphrrwwgbmrzrfexbcadtckgzkupwrhtogzhlpmzofvaugqckkkkmfxogdmqhcnblieofbjgzmxitfhwsvdxxjacenozyv"));
    }
}

