package com.wt.netty.rpc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/11 10:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class ApiTest {

    @Test
    public void init() throws InterruptedException {
        while (true) {
            Thread.sleep(5000);
        }
    }
}
