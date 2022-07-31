package com.wt.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.wt.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author: wtt
 * @date: 2022/7/31 11:33
 * @description:
 */
public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (null == mapperProxyFactory) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<?> type) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }


    public void addMappers(String packageName) {
        Set<Class<?>> mapperSer = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSer) {
            addMapper(mapperClass);
        }
    }
}
