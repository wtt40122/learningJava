package com.wt.spring.test16.bean;

import com.wt.spring.beans.factory.annotation.Autowired;
import com.wt.spring.beans.factory.annotation.Value;
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

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

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
        return "小家伙，100001，深圳->" + token + "-->" + userDao.queryUserName("10002");

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
