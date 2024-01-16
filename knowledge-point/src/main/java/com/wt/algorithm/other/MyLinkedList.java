package com.wt.algorithm.other;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2024/1/11 9:38
 */
public class MyLinkedList {

    private Node dummyHead;

    public MyLinkedList() {
        dummyHead = new Node(-1, null);
    }

    public int get(int index) {
        int count = 1;
        Node cur = dummyHead.next;
        while (cur != null) {
            if (count == index) {
                return cur.val;
            }
            count++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (dummyHead.next != null) {
            node.next = dummyHead.next.next;
            dummyHead.next = node;
        } else {
            dummyHead.next = node;
        }
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node cur = dummyHead.next;
        while (cur != null) {

        }
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }

    static class Node {

        private Integer val;

        private Node next;

        public Node() {
        }

        public Node(Integer val) {
            this.val = val;
        }

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
