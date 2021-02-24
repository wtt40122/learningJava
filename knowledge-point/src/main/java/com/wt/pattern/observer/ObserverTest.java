package com.wt.pattern.observer;

/**
 * @Auther: wtt
 * @Date: 2021/2/24 09:48
 * @Description:
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 定义发布者
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 定义订阅者
        ConcreteObserver concreteObserver1 = new ConcreteObserver("老王");
        ConcreteObserver concreteObserver2 = new ConcreteObserver("JAVA");
        // 添加订阅者
        concreteSubject.attach(concreteObserver1);
        concreteSubject.attach(concreteObserver2);
        // 发布信息
        concreteSubject.notify("消息更新了");
    }
}
