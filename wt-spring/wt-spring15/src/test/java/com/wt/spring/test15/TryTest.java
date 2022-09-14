package com.wt.spring.test15;

import org.junit.Test;

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
}
