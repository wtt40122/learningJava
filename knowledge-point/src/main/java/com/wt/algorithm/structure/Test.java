package com.wt.algorithm.structure;

/**
 * @Auther: wtt
 * @Date: 2021/2/2 13:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        for(int i=0;i<10;i++){
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
//        array.set(1,89);
//        System.out.println(array);
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
//        array.removeElement(2);
//        System.out.println(array);
    }

}
