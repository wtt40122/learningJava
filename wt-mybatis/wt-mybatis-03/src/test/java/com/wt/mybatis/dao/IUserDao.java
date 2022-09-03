package com.wt.mybatis.dao;

/**
 * @author: wtt
 * @date: 2022/7/31 20:18
 * @description:
 */
public interface IUserDao {

    String queryUserInfoById(String uId);

    String queryAllUsers();
}
