package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/4 09:45
 * @Description:
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
