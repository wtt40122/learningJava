package com.wt.tmall.spi;

import com.wt.tmall.model.LoginResponse;

/**
 * @author: wtt
 * @date: 2022/5/28 20:10
 * @description:
 */
public interface LoginService {

    LoginResponse login(String username, String password);
}
