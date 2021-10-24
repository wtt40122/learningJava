package com.wt.test;

/**
 * @Auther: wtt
 * @Date: 2021/4/23 11:30
 * @Description:
 */
public class Test9 {
    public static void main(String[] args) {
        Parent9 parent = new Parent9();
        System.out.println(Child2.str);
    }

    static class Parent9 {
        static {
            System.out.println("Parent9初始化！");
        }
    }

    static class Parent2 {
        public static String str = "hello world";

        static {
            System.out.println("Parent2 初始化");
        }
    }

    static class Child2 extends Parent2 {
        static {
            System.out.println("Child2 初始化");
        }
    }
}
