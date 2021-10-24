package com.wt.test.spi;

/**
 * @Auther: wtt
 * @Date: 2021/6/26 16:40
 * @Description:
 */
public class SpiImpl1 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl1.execute()");
    }
}
