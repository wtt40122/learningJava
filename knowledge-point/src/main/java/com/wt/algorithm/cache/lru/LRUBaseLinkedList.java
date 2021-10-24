package com.wt.algorithm.cache.lru;

import java.util.Scanner;

/**
 * @Auther: wtt
 * @Date: 2021/5/8 10:54
 * @Description:
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.next;
        preNode.next = temp.next;
        temp = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.next;
        SNode sNode = new SNode(data, next);
        headNode.next = sNode;
//        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.next != null) {
            if (data.equals(node.next.element)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.next == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.next.next != null) {
            ptr = ptr.next;
        }

        SNode tmp = ptr.next;
        ptr.next = null;
//        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.next;
        while (node != null) {
            System.out.print(node.element + ",");
            node = node.next;
        }
        System.out.println();
    }

    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
