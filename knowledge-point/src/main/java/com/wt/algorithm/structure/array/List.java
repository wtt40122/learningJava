package com.wt.algorithm.structure.array;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/28 15:11
 */
public interface List<E> {

    boolean add(E e);

    E remove(int index);

    E get(int index);
}
