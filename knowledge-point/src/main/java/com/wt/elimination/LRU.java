package com.wt.elimination;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/6/20 20:41
 */
public class LRU {
    LinkedList<Integer> lru = new LinkedList<Integer>();
    int size = 3;
    public class Dto implements Comparable<Dto> {
        private Integer key;
        private int count;
        private long lastTime;
        public Dto(Integer key, int count, long lastTime) {
            this.key = key;
            this.count = count;
            this.lastTime = lastTime;
        }
        @Override
        public int compareTo(Dto o) {
            int compare = Integer.compare(this.count, o.count);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
        @Override
        public String toString() {
            return String.format("[key=%s,count=%s,lastTime=%s]",key,count,lastTime);
        }
        public Integer getKey() {
            return key;
        }
        public void setKey(Integer key) {
            this.key = key;
        }
        public int getCount() {
            return count;
        }
        public void setCount(int count) {
            this.count = count;
        }
        public long getLastTime() {
            return lastTime;
        }
        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }
    }
    //添加元素
    public void add(int i) {
        lru.addFirst(i);
        if (lru.size() > size) {
            lru.removeLast();
        }
        print();
    }

    //缓存命中
    public void read(int i) {
        Iterator<Integer> iterator = lru.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            int j = iterator.next();
            if (i == j) {
                System.out.println("find it!");
                lru.remove(index);
                lru.addFirst(j);
                print();
                return;
            }
            index++;
        }
        System.out.println("not found!");
        print();
    }

    //打印缓存
    public void print() {
        System.out.println(this.lru);
    }

    //测试
    public static void main(String[] args) {
        LRU lru = new LRU();
        System.out.println("add 1‐3:");
        lru.add(1);
        lru.add(2);
        lru.add(3);
        System.out.println("add 4:");
        lru.add(4);
        System.out.println("read 2:");
        lru.read(2);
        System.out.println("read 100:");
        lru.read(100);
        System.out.println("add 5:");
        lru.add(5);
    }
}
