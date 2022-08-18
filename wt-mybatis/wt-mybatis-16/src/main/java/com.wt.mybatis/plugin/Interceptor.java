package com.wt.mybatis.plugin;

import java.util.Properties;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/18 10:26
 */
public interface Interceptor {

    // 拦截，使用方实现
    Object intercept(Invocation invocation) throws Throwable;

    // 代理
    default Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    // 设置属性
    default void setProperties(Properties properties) {
        // NOP
    }
}
