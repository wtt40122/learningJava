package com.wt.test.spi;

/**
 * @Auther: wtt
 * @Date: 2021/6/26 16:41
 * @Description:
 */
public class SpiImpl2 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl2.execute()");
    }
}
