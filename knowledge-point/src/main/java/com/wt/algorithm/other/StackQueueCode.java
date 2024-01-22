package com.wt.algorithm.other;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2024/1/22 13:20 栈和队列相关题
 */
public class StackQueueCode {
    /**
     * 用stack实现队列
     */
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.empty();
        }
    }

    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            int size = queue.size();
            while (size-- > 1) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if ('(' == s.charAt(i) || '{' == s.charAt(i) || '[' == s.charAt(i)) {
                stack.push(s.charAt(i));
            }
            if (')' == s.charAt(i) || '}' == s.charAt(i) || ']' == s.charAt(i)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (')' == s.charAt(i) && '(' != pop) {
                    return false;
                }
                if ('}' == s.charAt(i) && '{' != pop) {
                    return false;
                }
                if (']' == s.charAt(i) && '[' != pop) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackQueueCode stackQueueCode = new StackQueueCode();
        System.out.println(stackQueueCode.isValid("]"));
    }
}
