package com.wt.algorithm.leetCode;


import java.util.Stack;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/27 10:45
 */
public class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        int re = pop();
        this.stackOut.push(re);
        return re;
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        myQueue.push(34);
        System.out.println(myQueue.peek());
    }
}
