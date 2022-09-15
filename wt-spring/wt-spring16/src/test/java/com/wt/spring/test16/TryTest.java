package com.wt.spring.test16;

import cn.hutool.core.bean.BeanUtil;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/13 10:10
 */
public class TryTest {

    @Test
    public void test() {
        int i = 10;
        try {
            i = i / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            i = 2;
            return;
        }
    }

    @Test
    public void test_reflect() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();
//        Field[] declaredFields = studentClass.getDeclaredFields();
//        for (Field field : declaredFields) {
//            System.out.println(field.getName());
//        }
        final Field field = studentClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student,"张三");
        BeanUtil.setFieldValue(student,"name","里斯");
        System.out.println(student);
    }

    public static class Student{

        private String name;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
