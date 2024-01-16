package com.wt.algorithm.list;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2024/1/12 9:36
 */
public class Solution {
    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
