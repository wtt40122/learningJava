package com.wt.tmall.spi;

import com.wt.tmall.model.LoginResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: wtt
 * @date: 2022/5/28 20:24
 * @description:
 */
@Slf4j
public class SpringLoginService implements LoginService{
    @Override
    public LoginResponse login(String username, String password) {
        log.info("SpringLoginService,username:{},pawword:{}", username, password);
        return null;
    }
}
