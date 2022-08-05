package com.wt.mybatis.reflection.wrapper;

import com.wt.mybatis.reflection.MetaObject;

/**
 * @author wtt
 * @version 1.0
 * @description 对象包装工厂
 * @date 2022/8/2 10:58
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
