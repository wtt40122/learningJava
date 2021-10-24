package com.wt.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: wtt
 * @Date: 2021/4/20 19:50
 * @Description:
 */
public class MyBlockQueue<E> {

    private List<E> container = new ArrayList();
    private volatile int size;
    private volatile int capacity;
    private Lock lock = new ReentrantLock();

    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    public MyBlockQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(E e) {
        try {
            lock.lock();
            try {
                while (size >= capacity) {
                    System.out.println("阻塞队列满了");
                    isFull.await();
                }
            } catch (InterruptedException exception) {
                isFull.signal();
                exception.printStackTrace();
            }
            ++size;
            container.add(e);
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        try {
            lock.lock();
            try {
                while (size == 0) {
                    System.out.println("阻塞队列空了");
                    isEmpty.await();
                }
            } catch (InterruptedException e) {
                isEmpty.signal();
                e.printStackTrace();
            }
            --size;
            E res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue(5);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.put(i);
                System.out.println("塞入" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (; ; ) {
                System.out.println("消费" + queue.take());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }
}
