package com.wt.learn;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author wtt
 * @version 1.0
 * @description metaSpace oom
 * -XX:MetaspaceSize=10m -XX:MetaspaceSize=10m
 * @date 2023/11/8 9:37
 */
public class Demo07 {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            System.out.println("目前创建了" + (++count) + "个car的子类");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
                if (method.getName().equals("run")) {
                    System.out.println("汽车启动之间，先进行自动的安全检查.......");
                }
                return proxy.invokeSuper(obj, args1);
            });
            Car car = (Car) enhancer.create();
            car.run();
        }
    }

    static class Car {
        public void run() {
            System.out.println("汽车启动，开始行驶......");
        }
    }

}
