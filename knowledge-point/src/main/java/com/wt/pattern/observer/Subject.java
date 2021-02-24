package com.wt.pattern.observer;

/**
 * @Auther: wtt
 * @Date: 2021/2/24 09:43
 * @Description: 被观察者（消息发布方）
 */
public interface Subject {
    // 增加订阅者
    void attach(Observer observer);

    // 删除订阅者
    void detach(Observer observer);

    // 通知订阅者更新消息
    void notify(String message);
}

