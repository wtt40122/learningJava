package com.wt.mybatis.plugin;

/**
 * @author wtt
 * @version 1.0
 * @description 方法签名
 * @date 2022/8/18 10:28
 */
public @interface Signature {

    /**
     * 被拦截类
     */
    Class<?> type();

    /**
     * 被拦截类的方法
     */
    String method();

    /**
     * 被拦截类的方法的参数
     */
    Class<?>[] args();
}
