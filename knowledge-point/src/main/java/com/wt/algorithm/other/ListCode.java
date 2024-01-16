package com.wt.algorithm.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wtt
 * @Date: 2024/1/13 0:30
 * @Version: 1.0
 * @Description: 链表相关算法题
 */
public class ListCode {
    /**
     * 两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;

            cur.next = second;

            cur = first;
        }
        return dummyHead.next;
    }

    /**
     * 反转链表中的k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            ListNode cur = pre.next;
            ListNode preTemp = null;
            while (cur != null) {
                ListNode nextNode = cur.next;
                cur.next = preTemp;
                preTemp = cur;
                cur = nextNode;
            }
            pre.next = preTemp;
            start.next = next;
            pre = start;
            end = start;
        }
        return dummyHead.next;
    }

    /**
     * 反转链表中的k个节点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1 && pre != null; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode start = pre.next;
        ListNode preTemp = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = preTemp;
            preTemp = cur;
            cur = next;
        }
        pre.next = preTemp;
        start.next = cur;
        return dummyHead.next;
    }

    /**
     * 两个链表相交--hash法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> listA = new ArrayList();
        List<ListNode> listB = new ArrayList();
        while (null != headA) {
            listA.add(headA);
            headA = headA.next;
        }
        while (null != headB) {
            listB.add(headB);
            headB = headB.next;
        }
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listB.size(); j++) {
                if (listA.get(i) == listB.get(j)) {
                    return listA.get(i);
                }
            }
        }
        return null;
    }

    /**
     * 两个链表相交--双指针法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    /**
     * 链表环--hash法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet();
        while (null != cur) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    /**
     * 链表环--双指针法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode cur1 = fast;
                ListNode cur2 = head;
                while (cur1 != cur2) {
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                return cur1;
            }
        }
        return null;
    }

    public class ListNode {
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
