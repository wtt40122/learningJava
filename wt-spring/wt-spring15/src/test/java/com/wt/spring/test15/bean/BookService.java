package com.wt.spring.test15.bean;


import java.util.Random;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 17:48
 */
public class BookService implements IBookService {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String queryBookInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "张良，100001，深圳" + token;

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
}
