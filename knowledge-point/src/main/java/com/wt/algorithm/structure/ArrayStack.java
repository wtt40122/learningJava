package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/4 09:49
 * @Description:
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack size is:");
        res.append(getSize());
        res.append(",");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }


}
