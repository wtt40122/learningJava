package com.wt.mybatis.dao;

import com.wt.mybatis.pojo.User;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/1 14:23
 */
public interface IUserDao {

    User queryUserInfoById(Long uId);

}
