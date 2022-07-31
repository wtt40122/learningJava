package com.wt.mybatis.Dao;

/**
 * @author: wtt
 * @date: 2022/7/31 12:01
 * @description:
 */
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
