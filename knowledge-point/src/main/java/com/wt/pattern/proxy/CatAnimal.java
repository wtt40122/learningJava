package com.wt.pattern.proxy;

/**
 * @Auther: wtt
 * @Date: 2021/1/22 10:46
 * @Description:
 */
public class CatAnimal implements Animal {
    @Override
    public void eat() {
        System.out.println("猫正在吃东西");
    }
}
