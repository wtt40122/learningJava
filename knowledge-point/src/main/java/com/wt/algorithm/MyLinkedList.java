package com.wt.algorithm;

/**
 * @Author: wtt
 * @Date: 2024/1/11 21:53
 * @Version: 1.0
 * @Description:
 */
public class MyLinkedList {


    private Node dummyHead;

    private int size;


    public MyLinkedList() {
        dummyHead = new Node();
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val, dummyHead.next);
        dummyHead.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = new Node(val);
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    class Node {
        private Integer val;
        private Node next;

        public Node() {

        }

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(Integer val) {
            this.val = val;
        }
    }
}
