package com.wt.elimination;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LFU {
    private final int size = 3;
    private Map<Integer, Integer> cache = new HashMap<>();
    private Map<Integer, Dto> count = new HashMap<>();

    //投放
    public void put(Integer key, Integer value) {
        Integer v = cache.get(key);
        if (v == null) {
            if (cache.size() == size) {
                removeElement();
            }
            count.put(key, new Dto(key, 1, System.currentTimeMillis()));
        } else {
            addCount(key);
        }
        cache.put(key, value);
    }

    //读取
    public Integer get(Integer key) {
        Integer value = cache.get(key);
        if (value != null) {
            addCount(key);
            return value;
        }
        return null;
    }

    //淘汰元素
    private void removeElement() {
        Dto dto = Collections.min(count.values());
        cache.remove(dto.getKey());
        count.remove(dto.getKey());
    }

    //更新计数器
    private void addCount(Integer key) {
        Dto Dto = count.get(key);
        Dto.setCount(Dto.getCount() + 1);
        Dto.setLastTime(System.currentTimeMillis());
    }

    //打印缓存结构和计数器结构
    private void print() {
        System.out.println("cache=" + cache);
        System.out.println("count=" + count);
    }

    public static void main(String[] args) {
        LFU lfu = new LFU();
//前3个容量没满，1,2,3均加入
        System.out.println("add 1‐3:");
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.print();
//1,2有访问，3没有，加入4，淘汰3
        System.out.println("read 1,2");
        lfu.get(1);
        lfu.get(2);
        lfu.print();
        System.out.println("add 4:");
        lfu.put(4, 4);
        lfu.print();
//2=3次，1,4=2次，但是4加入较晚，再加入5时淘汰1
        System.out.println("read 2,4");
        lfu.get(2);
        lfu.get(4);
        lfu.print();
        System.out.println("add 5:");
        lfu.put(5, 5);
        lfu.print();
    }
}