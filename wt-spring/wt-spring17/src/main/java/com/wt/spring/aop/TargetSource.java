package com.wt.spring.aop;

import com.wt.spring.util.ClassUtils;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 17:14
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();

    }

    public Object getTarget() {
        return target;
    }
}
