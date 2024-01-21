package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/11 12:58
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
