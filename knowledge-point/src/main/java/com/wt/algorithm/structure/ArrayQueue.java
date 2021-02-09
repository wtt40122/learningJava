package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/5 14:45
 * @Description: 数组实现的队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
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
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue size is:");
        res.append(getSize());
        res.append(",");
        res.append("top [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
