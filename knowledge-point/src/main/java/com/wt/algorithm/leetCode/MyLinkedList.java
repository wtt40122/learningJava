package com.wt.algorithm.leetCode;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/17 13:50
 */
public class MyLinkedList {

    int size;
    ListNode dummyHead;

    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        int num = 0;
        ListNode current = this.dummyHead;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode currentNode = dummyHead.next;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        ListNode listNode = new ListNode(val);
        listNode.next = currentNode.next;
        currentNode.next = listNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode currentNode = dummyHead.next;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }

    public static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        MyLinkedList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, MyLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
