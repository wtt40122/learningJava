package com.wt.spring.test16.bean;

import com.wt.spring.beans.factory.FactoryBean;
import com.wt.spring.util.ClassUtils;

import java.lang.reflect.Proxy;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/16 17:00
 */
public class HusbandMother implements FactoryBean<IMother> {
    @Override
    public IMother getObject() throws Exception {
        return (IMother) Proxy.newProxyInstance(ClassUtils.getClassLoader(),
                new Class[]{IMother.class},
                (proxy, method, args) -> "婚后媳妇妈妈的职责被婆婆代理了！" + method.getName());
    }

    @Override
    public Class<?> getObjectType() {
        return IMother.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
