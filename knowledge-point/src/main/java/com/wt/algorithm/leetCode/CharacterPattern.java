package com.wt.algorithm.leetCode;

import java.util.Stack;

/**
 * @Auther: wtt
 * @Date: 2021/2/4 13:14
 * @Description: 括号匹配
 */
public class CharacterPattern {

    public static boolean isPattern(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topElem = stack.pop();
                if (str.charAt(i) == ')' && topElem != '(') {
                    return false;
                }
                if (str.charAt(i) == ']' && topElem != '[') {
                    return false;
                }
                if (str.charAt(i) == '}' && topElem != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isPattern("()"));
    }
}
