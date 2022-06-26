package com.wt.tmall.spi;

import java.util.ServiceLoader;

/**
 * @author: wtt
 * @date: 2022/5/28 20:39
 * @description:
 */
public class JavaSPI {
    public static void main(String[] args) {
        ServiceLoader<LoginService> serviceLoader = ServiceLoader.load(LoginService.class);
        for (LoginService loginService : serviceLoader) {
            loginService.login("哈哈","234432");
            break;
        }
    }
}
