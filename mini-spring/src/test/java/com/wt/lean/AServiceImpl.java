package com.wt.lean;

/**
 * @Author: wtt
 * @Date: 2023/12/14 0:13
 * @Version: 1.0
 * @Description:
 */
public class AServiceImpl implements AService{

    private String property1;

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    @Override
    public void sayHello() {
        System.out.println("service say hello test");
    }
}
