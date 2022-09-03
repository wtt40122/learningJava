package com.wt.spring03.bean;

/**
 * @author: wtt
 * @date: 2022/8/27 15:15
 * @description:
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(name);
        return super.toString() + sb.toString();
    }
}
