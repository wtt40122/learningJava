package com.wt.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/**
 * @Auther: wtt
 * @Date: 2021/12/21 22:29
 * @Description:
 */
public class TestType<K extends Comparable & Serializable, V> {

    Map<String, Integer> map;

    @Test
    public void testParam() throws NoSuchFieldException {
        Field field = TestType.class.getDeclaredField("map");
        System.out.println(field.getGenericType());
        System.out.println(field.getGenericType() instanceof ParameterizedType);
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        System.out.println(parameterizedType.getRawType());
        for (Type actualTypeArgument : parameterizedType.getActualTypeArguments()) {
            System.out.println(actualTypeArgument);
        }
        System.out.println(parameterizedType.getOwnerType());
    }

    K key;
    V value;

    @Test
    public void testTypeVariable() throws NoSuchFieldException {
// 获取字段的类型
        Field fk = TestType.class.getDeclaredField("key");
        Field fv = TestType.class.getDeclaredField("value");
//        Assert.that(fk.getGenericType() instanceof TypeVariable, "必须为TypeVariable类型");
//        Assert.that(fv.getGenericType() instanceof TypeVariable, "必须为TypeVariable类型");
        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();
        // getName 方法
        System.out.println(keyType.getName());                 // K
        System.out.println(valueType.getName());               // V
        // getGenericDeclaration 方法
        System.out.println(keyType.getGenericDeclaration());   // class com.test.TestType
        System.out.println(valueType.getGenericDeclaration()); // class com.test.TestType
        // getBounds 方法
        System.out.println("K 的上界:");                        // 有两个
        for (Type type : keyType.getBounds()) {                // interface java.lang.Comparable
            System.out.println(type);                          // interface java.io.Serializable
        }
        System.out.println("V 的上界:");                        // 没明确声明上界的, 默认上界是 Object
        for (Type type : valueType.getBounds()) {              // class java.lang.Object
            System.out.println(type);
        }
    }
}
