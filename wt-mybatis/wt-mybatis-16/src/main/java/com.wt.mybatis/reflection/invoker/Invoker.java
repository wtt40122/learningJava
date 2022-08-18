package com.wt.mybatis.reflection.invoker;

/**
 * @author wtt
 * @version 1.0
 * @description 调用者
 * @date 2022/8/2 10:41
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
