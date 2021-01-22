package com.wt.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: wtt
 * @Date: 2021/1/22 10:39
 * @Description: JDK动态代理 只能代理接口实现类
 */
public class AnimalProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法代理前");
        Object result = method.invoke(target, args);
        System.out.println("方法代理后");
        return result;
    }

    public static void main(String[] args) {
        AnimalProxy animalProxy = new AnimalProxy();
        Animal animal = (Animal) animalProxy.getInstance(new DogAnimal());
        animal.eat();
    }
}
