package com.wt.mybatis;

/**
 * @author: wtt
 * @date: 2022/7/30 18:47
 * @description:
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
