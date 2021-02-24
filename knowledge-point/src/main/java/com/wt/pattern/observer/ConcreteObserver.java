package com.wt.pattern.observer;

/**
 * @Auther: wtt
 * @Date: 2021/2/24 09:41
 * @Description: 观察者（消息接收方）
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ":" + message);
    }
}
