package com.wt.algorithm.structure.linked_list;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/28 11:19
 */
public interface List<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();
}
