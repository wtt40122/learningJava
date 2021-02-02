package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/1 09:25
 * @Description: 二次封装自定义数组
 */
public class Array<E> {
    // 数组
    private E[] data;
    // 数组中元素个数
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    // 获取数组容量
    public int getSize() {
        return size;
    }

    // 是否为空数组
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 在数组尾部插入元素
    public void addLast(E e) {
        data[size++] = e;
    }

    // 指定位置插入元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("插入数组的索引超出限制");
        }
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 头部插入元素
    public void addFirst(E e) {
        this.add(0, e);
    }

    // 获取元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取数组中数据的索引超出限制");
        }
        return data[index];
    }

    // 修改数组中指定位置处的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改数组中数据的索引超出限制");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除制定位置处的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除数组中数据的索引超出限制");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return ret;
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public void removeElement(E e) {
        int index = this.find(e);
        if (index != 1) {
            this.remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(String.format("数组的容量为%s,元素个数为%s \n", data.length, size));
        b.append('[');
        for (int i = 0; i < size; i++) {
            b.append(data[i]);
            if (i == size - 1)
                return b.append(']').toString();
            b.append(", ");
        }
        return b.toString();
    }
}
