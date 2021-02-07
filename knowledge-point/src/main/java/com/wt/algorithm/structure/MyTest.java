package com.wt.algorithm.structure;

import org.junit.Test;

/**
 * @Auther: wtt
 * @Date: 2021/2/2 13:09
 * @Description:
 */
public class MyTest {

    @Test
    public void testArray() {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.addLast(8);
        System.out.println(array);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        array.addFirst(3);
        System.out.println(array);
        array.set(1,89);
        System.out.println(array);
        array.remove(2);
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeElement(2);
        System.out.println(array);

    }

    @Test
    public void testStack() {
        Stack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        Integer popEle = arrayStack.pop();
        System.out.println("弹出的栈顶元素为：" + popEle);
        System.out.println(arrayStack);
        System.out.println("栈顶元素为：" + arrayStack.peek());
    }

    @Test
    public void testQueue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
        }
        System.out.println("队头元素：" + arrayQueue.getFront());
        System.out.println("出队的元素为" + arrayQueue.deQueue());
        System.out.println("出队的元素为" + arrayQueue.deQueue());
        System.out.println(arrayQueue);
    }

    @Test
    public void testLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue();
        for (int i = 0; i < 10; i++) {
            loopQueue.enQueue(i);
            System.out.println(loopQueue);
        }
        System.out.println("队头元素：" + loopQueue.getFront());
        System.out.println("出队的元素为" + loopQueue.deQueue());
        System.out.println("出队的元素为" + loopQueue.deQueue());
        System.out.println(loopQueue);
    }
}
