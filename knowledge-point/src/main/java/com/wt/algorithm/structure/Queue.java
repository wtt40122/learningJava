package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/5 14:42
 * @Description:
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enQueue(E e);

    E deQueue();

    E getFront();
}
