package com.wt.pattern.proxy;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: wtt
 * @Date: 2021/4/14 11:42
 * @Description:
 */
public class Test {

    @org.junit.Test
    public void proxyList() {
        final List<String> list = new LinkedList<>();
        List<String> stringList = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(!method.getName().equals("toString")){
                    System.out.println("我是代理的");
                }
                return method.invoke(list, args);
            }
        });
        stringList.add("23");
        System.out.println(stringList);
    }
}
