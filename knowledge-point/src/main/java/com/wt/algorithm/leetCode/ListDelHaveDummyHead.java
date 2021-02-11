package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/11 12:57
 * @Description: 删除链表中等于给定值 val 的所有节点。有虚拟头结点
 */
public class ListDelHaveDummyHead {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }
}
