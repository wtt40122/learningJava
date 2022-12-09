package com.wt.jvm;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/12/9 16:22
 */
public class TestAddUrl {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, MalformedURLException {
        URLClassLoader classLoader = (URLClassLoader) TestAddUrl.class.getClassLoader();
        String dir = "./lib";
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(classLoader, new File(dir).getAbsoluteFile().toURL());

        Class klass = Class.forName("com.wt.jvm.HelloKimmking", true, classLoader);
        Object obj = klass.newInstance();
        Method hello = klass.getDeclaredMethod("hello");
        hello.invoke(obj);
    }
}
