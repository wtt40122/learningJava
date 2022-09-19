package com.wt.spring.test16;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wtt
 * @version 1.0
 * @description 一级缓存解决循环依赖
 * @date 2022/9/16 15:45
 */
public class CircleTest {

    public static void main(String[] args) throws Exception {
        System.out.println(getBean(A.class).getB());
        System.out.println(getBean(B.class).getA());
    }

    private final static Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private static <T> T getBean(Class<T> beanClass) throws Exception {
        String beanName = beanClass.getSimpleName().toLowerCase();
        if (singletonObjects.containsKey(beanName)) {
            return (T) singletonObjects.get(beanName);
        }
        // 实例化对象入缓存
        Object obj = beanClass.newInstance();
        singletonObjects.put(beanName, obj);
        // 属性填充补全对象
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            field.set(obj, singletonObjects.containsKey(fieldBeanName) ?
                    singletonObjects.get(fieldBeanName) : getBean(fieldClass));

        }
        return (T) obj;
    }

}

class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
