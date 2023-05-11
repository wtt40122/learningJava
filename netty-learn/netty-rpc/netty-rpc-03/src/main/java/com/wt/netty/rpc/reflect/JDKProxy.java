package com.wt.netty.rpc.reflect;

import com.wt.netty.rpc.network.msg.Request;
import com.wt.netty.rpc.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 9:54
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, Request request) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(request);
        ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, handler);
        return result;
    }
}
