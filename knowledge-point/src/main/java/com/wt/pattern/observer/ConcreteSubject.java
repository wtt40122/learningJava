package com.wt.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wtt
 * @Date: 2021/2/24 09:46
 * @Description: 具体被观察者（消息发布方）
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
