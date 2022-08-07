package com.wt.mybatis;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: wtt
 * @date: 2022/7/30 18:25
 * @description: 映射器代理类
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = -7690237186036732495L;

    private Map<String, Object> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, Object> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        String sqlKey = mapperInterface.getName() + "." + method.getName();
        System.out.println("你被代理了：" + sqlKey + ":" + sqlSession.get(sqlKey));
        return sqlSession.get(sqlKey);
    }
}
