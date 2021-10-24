package com.wt.test;

/**
 * @Auther: wtt
 * @Date: 2021/5/12 20:34
 * @Description:
 */
public class Test3 {

    public static String sumStr(String str1, String str2) {
        int sumKey = 0;
        int s1 = str1.length() - 1;
        int s2 = str2.length() - 1;
        int temp = 0;
        int temp1 = 0;
        while (s1 >= 0 || s2 >= 0) {
            char s1key = '0';
            if (s1 >= 0) {
                s1key = str1.charAt(s1);
            }
            char s2key = '0';
            if (s1 >= 0) {
                s1key = str1.charAt(s1);
            }
            int sum = Integer.valueOf(s1key) + Integer.valueOf(s2key);
            if (sum >= 10) {
                temp = sum % 10;
                temp1 = 1;
            }
            sumKey = temp * 10 + sum;
            s1--;
            s2--;
        }

        return sumKey + "";
    }

    public static void main(String[] args) {
        String s1 = "99";
        String s2 = "1";
        System.out.println(sumStr(s1, s2));
    }
}
