package com.wt.algorithm.leetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/27 13:10
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        while (size > 1) {
            Integer re = queue.poll();
            queue.add(re);
            size--;
        }
        return queue.poll();
    }

    public int top() {
        int pop = pop();
        queue.add(pop);
        return pop;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
