package com.wt.elimination;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/6/20 20:15
 */
public class FIFO<T> {

    private Integer capacity;

    LinkedList<T> cache = new LinkedList<>();

    public FIFO() {
        this.capacity = 16;
    }

    public FIFO(int capacity) {
        this.capacity = capacity;
    }

    public void add(T t) {
        cache.addFirst(t);
        if (cache.size() > capacity) {
            cache.removeLast();
        }
        print();
    }

    public T read(T t) {
        Iterator<T> iterator = cache.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next == t) {
                print();
                return t;
            }
        }
        return null;
    }

    public void print() {
        System.out.println(this.cache);
    }

    //测试
    public static void main(String[] args) {
        FIFO fifo = new FIFO(3);
        System.out.println("add 1‐3:");
        fifo.add(1);
        fifo.add(2);
        fifo.add(3);
        System.out.println("add 4:");
        fifo.add(4);
        System.out.println("read 2:");
        fifo.read(2);
        System.out.println("read 100:");
        fifo.read(100);
        System.out.println("add 5:");
        fifo.add(5);
    }
}
