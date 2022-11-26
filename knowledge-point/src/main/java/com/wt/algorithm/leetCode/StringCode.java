package com.wt.algorithm.leetCode;

import java.util.*;

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

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (needle.length() > haystack.length()) {
            return index;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystackChars.length; i++) {
            int startedIndex = i;
            for (int j = 0; j < needleChars.length; j++) {
                if (startedIndex >= haystackChars.length || haystackChars[startedIndex] != needleChars[j]) {
                    break;
                }
                startedIndex++;
            }
            if (i + needle.length() == startedIndex) {
                return i;
            }
        }
        return index;
    }

    /**
     * kmp算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrKmp(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }
            next[i] = j;
        }
    }

    public static void test() {
        String s = "8264";
        int[] next = new int[s.length()];
        s.charAt(0);
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            // 将字符转化成数字
            number = 10 * number + (s.charAt(i) - '0');
            System.out.println((number));
        }
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.toCharArray().length; i++) {
            int start = i;
            for (int j = 0; j < s.toCharArray().length; j++) {
                if (s.charAt(start) != s.charAt(j)) {
                    break;
                }
            }
        }
        return false;
    }

    public static String replaceSpace1(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }
        char[] newChars = new char[s.length() + 2 * count];
        int slow = 0;
        int fast = 0;
        while (slow < s.length()) {
            if (s.charAt(slow) == ' ') {
                newChars[fast] = '%';
                newChars[++fast] = '2';
                newChars[++fast] = '0';
            } else {
                newChars[fast] = s.charAt(slow);
            }
            fast++;
            slow++;
        }
        return new String(newChars);
    }

    public static String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] spaceStrs = s.trim().split(" ");
        for (int i = spaceStrs.length - 1; i >= 0; i--) {
            if (spaceStrs[i] != "" && i != 0) {
                sb.append(spaceStrs[i]).append(" ");
            }
            if (spaceStrs[i] != "" && i == 0) {
                sb.append(spaceStrs[i]);
            }
        }
        return sb.toString();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode curA = headA;
        Set<ListNode> nodes = new HashSet<>();
        while (null != curA) {
            nodes.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while (null != curB) {
            if (nodes.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode cur = head;
        while (null != cur) {
            if (nodes.contains(cur)) {
                return cur;
            } else {
                nodes.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycleD(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(replaceSpaceDp("We are happy."));
//        System.out.println(reverseWords2("a good   example"));
//        System.out.println(removeSpace("a good   example"));
//        System.out.println(reverseLeftWords2("lrloseumgh", 6));
//        System.out.println(strStr("mississippi", "issipi"));
        System.out.println(replaceSpace1("We are happy."));
        System.out.println(reverseWords1("  hello world  "));
    }
}
