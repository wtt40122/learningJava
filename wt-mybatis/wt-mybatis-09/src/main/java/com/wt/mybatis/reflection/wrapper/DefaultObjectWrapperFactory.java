package com.wt.mybatis.reflection.wrapper;

import com.wt.mybatis.reflection.MetaObject;

/**
 * @author wtt
 * @version 1.0
 * @description 默认对象包装工厂
 * @date 2022/8/2 10:59
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
