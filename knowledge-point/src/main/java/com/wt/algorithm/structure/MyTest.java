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

    @Test
    public void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,5656);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    @Test
    public void testLinkedListStack(){
        Stack<Integer> listStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            listStack.push(i);
            System.out.println(listStack);
        }
        Integer popEle = listStack.pop();
        System.out.println("弹出的栈顶元素为：" + popEle);
        System.out.println(listStack);
        System.out.println("栈顶元素为：" + listStack.peek());
    }

    @Test
    public void testLinkedListQueue() {
        LinkedListQueue<Integer> listQueue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            listQueue.enQueue(i);
            System.out.println(listQueue);
        }
        System.out.println("队头元素：" + listQueue.getFront());
        System.out.println("出队的元素为" + listQueue.deQueue());
        System.out.println("出队的元素为" + listQueue.deQueue());
        System.out.println(listQueue);
    }
}
