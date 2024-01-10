package com.wt.algorithm.other;

/**
 * @Author: wtt
 * @Date: 2024/1/4 22:51
 * @Version: 1.0
 * @Description:
 */
public class StringTest {

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

    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }
}

