package com.wt.algorithm.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

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
            } else {
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
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next;

            cur.next = temp2;
            temp2.next = temp1;
            temp1.next = temp2.next;

            cur = temp2;
        }
        return dummyHead.next;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (null != p1 && null != p2) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (null != p1) {
            p.next = p1;
        }
        if (null != p2) {
            p.next = p2;
        }
        return dummy.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-2);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while (null != p) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        if (0 == lists.length) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,
                Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (null != head) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (null != node.next) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (null != p2 && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
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
