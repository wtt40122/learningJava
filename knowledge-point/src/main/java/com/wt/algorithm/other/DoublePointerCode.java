package com.wt.algorithm.other;

import com.wt.algorithm.leetCode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2024/1/20 21:57
 * @Version: 1.0
 * @Description: 双指针解决问题
 */
public class DoublePointerCode {
    /**
     * 删除数组中的元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    /**
     * 替换数字
     *
     * @param s
     * @return
     */
    public String replaceNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append("number");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 发转单词
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = removeSpace(s);
        s = reverseWords(s, 0, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        int end = 0;
        for (int start = 0; start < s.length(); start++) {
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            sb.append(reverseWords(s, start, end - 1));
            if (end != s.length()) {
                sb.append(" ");
            }
            start = end;
            end = start + 1;
        }
        return sb.toString();
    }

    private String removeSpace(String s) {
        int left = 0, right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char temp = s.charAt(left);
            if (temp != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(temp);
            }
            left++;
        }
        return sb.toString();
    }

    private String reverseWords(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            sb.append(s.charAt(end));
            end--;
        }
        return sb.toString();
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 移除倒数第n个元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    /**
     * 获取链表的交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        List<ListNode> visited = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            if (visited.contains(cur)) {
                return cur;
            } else {
                visited.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode curA = head;
                ListNode curB = fast;
                while (curA != curB) {
                    curA = curA.next;
                    curB = curB.next;
                }
                return curA;
            }

        }
        return null;
    }

    /**
     * 三数和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (num == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                } else if (num < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 四数和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long num = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (num == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (num < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "the sky is blue";
        DoublePointerCode doublePointerCode = new DoublePointerCode();
        System.out.println(doublePointerCode.reverseWords(str));
    }

}
