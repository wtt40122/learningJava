package com.wt.spring.test10.bean;

import com.wt.spring.beans.factory.FactoryBean;
import com.wt.spring.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 14:37
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("10001", "研发效能组");
            dataMap.put("10002", "新零售");
            dataMap.put("10003", "云平台");
            return "你被代理了" + method.getName() + ":" + dataMap.get(args[0].toString());
        });
        return (IUserDao) Proxy.newProxyInstance(ClassUtils.getClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
