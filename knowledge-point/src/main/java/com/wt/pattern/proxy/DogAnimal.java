package com.wt.pattern.proxy;

/**
 * @author wangtao
 * @Auther: wtt
 * @Date: 2021/1/22 10:44
 * @Description:
 */
public class DogAnimal implements Animal {
    @Override
    public void eat() {
        System.out.println("狗正在吃东西");
    }
}
