package com.wt.algorithm.leetCode;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/17 0:07
 */
public class LinkedListCode {

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode current = dummyHead;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode5 = new ListNode(2, listNode1);
        ListNode listNode6 = new ListNode(2, listNode5);
        ListNode listNode7 = new ListNode(1, listNode6);

        ListNode listNode = removeElements(listNode7, 2);
        System.out.println("1");
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
