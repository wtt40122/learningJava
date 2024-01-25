package com.wt.algorithm.other;

import java.util.*;

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

    /**
     * 括号匹配
     *
     * @param s
     * @return
     */
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

    /**
     * 移除相邻的重复字符
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int length = sb.length();
            if (length > 0 && c == sb.charAt(length - 1)) {
                sb.deleteCharAt(length - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 滑动窗口最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        MyMonQueue monQueue = new MyMonQueue();
        List<Integer> list = new ArrayList<>();
        while (right < nums.length) {
            monQueue.push(nums[right]);
            if (right - left + 1 == k) {
                list.add(monQueue.max());
                monQueue.pop(nums[left]);
                left++;
            }
            right++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    class MyMonQueue {
        private Deque<Integer> deque;

        public MyMonQueue() {
            deque = new LinkedList<>();
        }

        public void push(int x) {
            while (!deque.isEmpty() && deque.peekLast() < x) {
                deque.pollLast();
            }
            deque.offerLast(x);
        }

        public void pop(int x) {
            if (!deque.isEmpty() && deque.peekFirst() == x) {
                deque.pollFirst();
            }
        }

        public int max() {
            return deque.peek();
        }
    }

    public static void main(String[] args) {
        StackQueueCode stackQueueCode = new StackQueueCode();
//        System.out.println(stackQueueCode.removeDuplicates("abbaca"));
        int[] nums = new int[]{-7, -8, 7, 5, 7, 1, 6, 0};
        int[] result = stackQueueCode.maxSlidingWindow(nums, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
