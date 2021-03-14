package com.wt.algorithm.other;

/**
 * @Auther: wtt
 * @Date: 2021/3/1 10:02
 * @Description: byte short int long float double char boolean
 */
public class Test {
    public static void main(String[] args) {
        short s = 1;
        s = (short) (s + 1);

        short s21 = 1;
        s21 += 1;

        Integer a = new Integer(3);
        Integer b = 3; // 将 3 自动装箱成 Integer 类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对 象
        System.out.println(a == c); // true a 自动拆箱成 int 类型再和 c

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);


        int a1 = 5, b1 = 10;
        swap(a1, b1); // a = 10, b = 5; 第 225 页 共 485 页
        // Console.WriteLine ("a = {0}, b = {1}", a, b);
        System.out.println(String.format("a = %s, b = %s", a1, b1));


        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
