package com.wt.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

/**
 * @Auther: wtt
 * @Date: 2021/1/22 10:39
 * @Description: JDK动态代理 只能代理接口实现类
 */
public class AnimalTest {

    public static void main(String[] args) {
//        jdkProxy();
        cglibProxy();
    }

    /**
     * JDK动态代理
     */
    private static void jdkProxy() {
        System.out.println("JDK动态代理，接口实现必须有子类");
        final DogAnimal dogAnima = new DogAnimal();
        Animal animal = (Animal) Proxy.newProxyInstance(dogAnima.getClass().getClassLoader(), dogAnima.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("方法代理前");
                    Object result = method.invoke(dogAnima, args);
                    System.out.println("方法代理后");
                    return result;
                });
        animal.eat();
    }

    /**
     * cglib动态代理
     */
    private static void cglibProxy() {
        System.out.println("CGLIB动态代理，直接对类进行代理");
        CatAnimal animal = (CatAnimal) Enhancer.create(new CatAnimal().getClass(),
                (MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("方法代理前");
            Object result = method.invoke(new CatAnimal(), objects);
            System.out.println("方法代理后");
            return result;
        });
        animal.eat();
    }
}
