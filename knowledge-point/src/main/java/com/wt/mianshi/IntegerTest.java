package com.wt.mianshi;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: wtt
 * @Date: 2021/4/20 09:55
 * @Description:
 */
public class IntegerTest {
    public static void main(String[] args) {
        int i = 128;
        Integer i2 = 128;
        int i21 = 4559;
        Integer i22 = 4559;
        Integer i3 = new Integer(128);
        //Integer会自动拆箱为int，所以为true
        System.out.println(i == i2); //true
        System.out.println(i21 == i22);
        System.out.println(i == i3);    //true
        System.out.println("**************");
        Integer i5 = 127; //java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6); //true
        Integer i9 = 128;
        Integer i10 = 128;
        System.out.println(i9 == i10); //false
        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); //false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8);  //false
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    }


}
