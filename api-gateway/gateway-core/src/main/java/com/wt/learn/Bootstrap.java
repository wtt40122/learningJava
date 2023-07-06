package com.wt.learn;

/**
 * @Author: wtt
 * @Date: ${DATE} $TIME
 * @Description:
 */
public class Bootstrap {
    public static void main(String[] args) {
        Config config = ConfigureLoader.getInstance().load(args);
        System.out.println(config.getPort());
    }
}