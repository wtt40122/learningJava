package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/6 18:10
 * @Description:
 */
public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不合适，插入失败");
        }
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e,prev.next);
        size++;
    }

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e,head);
//        size++;
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
}
