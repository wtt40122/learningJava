package com.wt.algorithm.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/27 13:31
 */
public class StackQueueCode {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    public static String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 逆波兰表达式求值
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!"+".equals(tokens[i]) && !"-".equals(tokens[i]) && !"*".equals(tokens[i]) && !"/".equals(tokens[i])) {
                stack.push(tokens[i]);
            } else if (tokens[i].equals("+")) {
                Integer first = Integer.valueOf(stack.pop());
                Integer second = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(first + second));
            } else if (tokens[i].equals("-")) {
                Integer first = Integer.valueOf(stack.pop());
                Integer second = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(second - first));
            } else if (tokens[i].equals("*")) {
                Integer first = Integer.valueOf(stack.pop());
                Integer second = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(first * second));
            } else if (tokens[i].equals("/")) {
                Integer first = Integer.valueOf(stack.pop());
                Integer second = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(second / first));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    /**
     * 逆波兰表达式求值 精简版
     *
     * @param tokens
     * @return
     */
    public static int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(tokens[i])) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second - first);
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    /**
     * 滑动窗口最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int left = 0;
        int right = 0;
        int[] res = new int[nums.length - k + 1];
        while (right < nums.length) {
            while (right - left < k) {
                list.add(nums[right]);
                right++;
            }
            res[left] = Collections.max(list);
            list.remove(0);
            left++;
        }
        return res;
    }

    /**
     * 单调队列求滑动窗口最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length < k) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int index = 0;
        res[index++] = myQueue.getMaxValue();
        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i - k]);
            myQueue.push(nums[i]);
            res[index++] = myQueue.getMaxValue();
        }
        return res;
    }

    public static class MyQueue {
        Deque<Integer> queue = new ArrayDeque<>();

        public void pop(Integer value) {
            if (!queue.isEmpty() && queue.peek().equals(value)) {
                queue.poll();
            }
        }

        public void push(int ele) {
            while (!queue.isEmpty() && ele > queue.getLast()) {
                queue.pollLast();
            }
            queue.add(ele);
        }

        public int getMaxValue() {
            return queue.peek();
        }

    }

    /**
     * 频次最高的前k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> collect = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            res[i] = collect.get(i);
        }
        return res;
    }

    /**
     * 频次最高的前k个元素，采用堆实现
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequentHeap(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("()"));
//        System.out.println(removeDuplicates("abbaca"));
//        System.out.println(removeDuplicates1("abbaca"));
//        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
//        Arrays.stream(maxSlidingWindow1(new int[]{1, 3, 1, 2, 0, 5}, 3)).forEach(System.out::println);
        Arrays.stream(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(System.out::println);
        System.out.println("------");
        Arrays.stream(topKFrequentHeap(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(System.out::println);
    }
}
