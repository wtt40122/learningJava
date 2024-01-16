package com.wt.algorithm.list;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2024/1/12 9:34
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
