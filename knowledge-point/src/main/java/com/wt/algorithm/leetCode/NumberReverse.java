package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/24 13:12
 * @Description: 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberReverse {

    public static int reverse(int x) {
        try {
            String xStr = String.valueOf(x);
            StringBuilder sb = new StringBuilder();
            for (int i = xStr.length() - 1; i >= 0; i--) {
                sb.append(xStr.charAt(i));
            }
            if (sb.toString().endsWith("-")) {
                xStr = "-" + Integer.valueOf(sb.substring(0, xStr.length() - 1));
                return Integer.valueOf(xStr);
            } else {
                return Integer.parseInt(sb.toString());
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse1(1463847412));
    }
}
