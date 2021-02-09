package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/9 13:13
 * @Description: 链表实现的队列
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列对空，不能出队");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列对空，不能拿到栈顶元素");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");
        Node cur = head;
        while(cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
