package com.wt.test;

/**
 * @Auther: wtt
 * @Date: 2021/5/24 15:35
 * @Description:
 */
public class Testbdu {
//     1 4 3 2 5 2    3
//
//     1 2 2 4 3 5

    public static void main(String[] args) {
        method(null);
    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

}
