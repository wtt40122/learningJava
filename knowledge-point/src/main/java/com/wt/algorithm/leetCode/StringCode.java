package com.wt.algorithm.leetCode;

/**
 * @author: wtt
 * @date: 2022/11/23 23:16
 * @description:
 */
public class StringCode {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k < chars.length) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            reverse(chars, i, chars.length - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }


    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String replaceSpaceDp(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        char[] newChars = new char[s.length() + 2 * count];
        int oldRight = s.length() - 1;
        int newRight = newChars.length - 1;
        while (oldRight >= 0) {
            if (chars[oldRight] == ' ') {
                newChars[newRight] = '0';
                newChars[--newRight] = '2';
                newChars[--newRight] = '%';
            } else {
                newChars[newRight] = chars[oldRight];
            }
            newRight--;
            oldRight--;
        }
        return new String(newChars);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if ((i == 0 || i == s.length() - 1) && s.charAt(i) == ' ') {
                continue;
            }
            if (strs[i].equals("")) {
                continue;
            } else {
                sb.append(" " + strs[i]);
            }
        }
        return sb.toString().trim();
    }

    /**
     * 另一种解法
     *
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        // 移除前后空格及中间多余的空格
        StringBuilder removeSpace = removeSpace(s);
        // 翻转字符串
        reverseStr(removeSpace, 0, removeSpace.length() - 1);
        // 反转每个字符串
        reversePerWord(removeSpace);
        return removeSpace.toString();
    }

    public static void reversePerWord(StringBuilder sb) {
        int slow = 0;
        int fast = 0;
        while (slow < sb.length()) {
            while (fast < sb.length() && sb.charAt(fast) != ' ') {
                fast++;
            }
            reverseStr(sb, slow, fast - 1);
            slow = fast + 1;
            fast = slow + 1;
        }
    }

    public static void reverseStr(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(end);
            sb.setCharAt(end, sb.charAt(start));
            sb.setCharAt(start, temp);
            start++;
            end--;
        }
    }

    public static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(start));
            }
            start++;
        }
        return sb;
    }

    public static String reverseLeftWords(String s, int n) {
        if (s.length() < n) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s, 0, n);
        return sb.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseStr(sb, 0, n - 1);
        reverseStr(sb, n, s.length() - 1);
        reverseStr(sb, 0, s.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(replaceSpaceDp("We are happy."));
//        System.out.println(reverseWords2("a good   example"));
//        System.out.println(removeSpace("a good   example"));
        System.out.println(reverseLeftWords2("lrloseumgh", 6));
    }
}
