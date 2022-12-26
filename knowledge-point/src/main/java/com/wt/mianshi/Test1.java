package com.wt.mianshi;

/**
 * @Auther: wtt
 * @Date: 2021/4/19 20:56
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Integer i = new Integer(100);
        int j = 100;
        System.out.println(i == j); //true
        study();
    }

    public static void study() {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        //会自动装箱，调用Integer.valueOf(),由于40在-128到127之间，会从缓存中拿一个对象,所以是一个对象
        System.out.println("i1=i2   " + (i1 == i2)); // true 常量池
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));    //true
        System.out.println("i1=i4   " + (i1 == i4));    //false
        System.out.println("i4=i5   " + (i4 == i5));    //false
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));    //true
        System.out.println("40=i5+i6   " + (40 == i5 + i6));    //true

        Integer i7 = 200;
        Integer i8 = new Integer(200);
        System.out.println("i7=i8   " + (i7 == i8)); //false

        Integer i = 100;
        Integer j = 100;
        System.out.println(i == j); //true

        Integer i23 = 128;
        Integer j23 = 128;
        System.out.println(i23 == j23); //false

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        System.out.println(c == (a + b)); //true
        System.out.println(c.equals(a + b)); //true
    }
}
