package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/11 12:57
 * @Description: 删除链表中等于给定值 val 的所有节点。
 */
public class ListDelNoDummyHead {
    public ListNode removeElements(ListNode head, int val) {
        // 头结点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        if (null == head) {
            return null;
        }
        // 链表中点的元素
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
