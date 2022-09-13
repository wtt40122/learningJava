package com.wt.spring.test14.bean;

import com.wt.spring.stereotype.Component;

import java.util.Random;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/12 19:53
 */
@Component("schoolService")
public class SchoolService implements ISchoolService {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小家伙，100001，深圳->" + token;

    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";

    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }
}
