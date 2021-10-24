package com.wt.test;

import java.util.concurrent.Exchanger;

/**
 * @Auther: wtt
 * @Date: 2021/4/22 10:18
 * @Description: 1 Exchanger中的public V exchange(V x)方法被调用后等待另一个线程到达交换点（如果当前线程没有被中断），
 * * 然后将已知的对象传给它，返回接收的对象。
 * * 2 交换的线程需要是偶数，不能是基数，否则就会有线程在等待交换一直阻塞。
 */
public class ExchangerDemo {
    public class Car extends Thread {
        private Exchanger<String> exchanger;

        public Car(Exchanger<String> exchanger) {
            super("car");
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + exchanger.exchange(name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Bike extends Thread {
        private Exchanger<String> exchanger;

        public Bike(Exchanger<String> exchanger) {
            super("bike");
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + exchanger.exchange(name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerDemo exchangerTest = new ExchangerDemo();
        Car car = exchangerTest.new Car(exchanger);
        Car car2 = exchangerTest.new Car(exchanger);
        Bike bike = exchangerTest.new Bike(exchanger);
        Bike bike2 = exchangerTest.new Bike(exchanger);
        car2.setName("car2");
        bike2.setName("bike2");
        car.start();
        bike.start();
        car2.start();
        bike2.start();
        System.out.println("Main end!");
    }

}
