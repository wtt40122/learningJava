package com.wt.algorithm.structure;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/29 15:04
 */
public class TestSimple {

    @Test
    public void test_copy() {
        String[] oldStr = {"1", "2", "3"};
        String[] newStr = Arrays.copyOf(oldStr, 5);
        Arrays.stream(newStr).forEach(System.out::println);
        /**
         * 数据拷贝过去后，在新数组中不存在的数据都默认是null
         */
        Integer[] oldInt = {1, 2, 3};
        Integer[] newInt = Arrays.copyOf(oldInt, 5);
        Arrays.stream(newInt).forEach(System.out::println);
    }

    @Test
    public void test_arr_copy() {
        String[] oldStr = {"1", "2", "3", "4", "5"};
        System.arraycopy(oldStr, 4, oldStr, 3, 1);
        oldStr[4] = null;
        Arrays.stream(oldStr).forEach(System.out::println);
    }
}
