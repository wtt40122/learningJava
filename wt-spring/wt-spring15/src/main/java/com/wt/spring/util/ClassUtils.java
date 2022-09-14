package com.wt.spring.util;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 16:31
 */
public class ClassUtils {

    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
        }
        if (null == classLoader) {
            classLoader = ClassUtils.class.getClassLoader();
            if (null == classLoader) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
        }
        return classLoader;
    }

    public static boolean isCglibProxyClass(Class<?> clazz) {
        return null != clazz && isCglibProxyClassName(clazz.getName());
    }

    public static boolean isCglibProxyClassName(String clasName) {
        return null != clasName && clasName.contains("$$");
    }
}
