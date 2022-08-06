package com.wt.mybatis.dao;


import com.wt.mybatis.pojo.User;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/1 14:23
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

    User queryUserInfo(User req);

    List<User> queryUserInfoList();

    int updateUserInfo(User req);

    void insertUserInfo(User req);

    int deleteUserInfoByUserId(String userId);
}
