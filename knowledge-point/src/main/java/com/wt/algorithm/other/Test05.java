package com.wt.algorithm.other;

/**
 * @author wtt
 * @version 1.0
 * @description
 * <br>类的主动引用（发生类的初始化）
 *      当虚拟机启动时，先初始化main方法所在的类
 *       new 一个类的对象
 *      调用类的静态成员（除了final常量）和静态方法
 *      使用java.lang.reflect包的方法对类进行反射调用
 *      当初始化一个类，如果没有没有初始化，先初始化父类
 * 类的被动引用（不会发生类的初始化）
 *      应用父类的静态变量时，子类不会初始化
 *      通过数组定义类应用，不会触发类的初始化
 *      引用常量不会触发类的初始化
 *  </>
 * @date 2024/1/3 19:54
 */
public class Test05 {

    public static void main(String[] args) throws ClassNotFoundException {
//         Son son = new Son();

//         Class.forName("com.wt.algorithm.other.Son");

        System.out.println(Son.b);
//        System.out.println(Son.m);
        System.out.println(Son.M);

        Son[] array = new Son[3];
    }
}

class Father {

    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
