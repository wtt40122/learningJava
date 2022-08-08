package com.wt.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author wtt
 * @version 1.0
 * @description getter 调用者
 * @date 2022/8/2 10:43
 */
public class GetFieldInvoker implements Invoker {

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
