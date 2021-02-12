package com.wt.algorithm.leetCode;

/**
 * @Auther: wtt
 * @Date: 2021/2/12 16:31
 * @Description: 反转链表
 */
public class ReverseList {
    /**
     *
     * @Description //非递归实现
     * @Author wtt
     * @Date 2021/2/12 16:40
     * @param: [head]
     * @return com.wt.algorithm.leetCode.ListNode
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    /**
     *
     * @Description //递归实现
     * @Date 2021/2/12 16:40
     * @param: [head]
     * @return com.wt.algorithm.leetCode.ListNode
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
