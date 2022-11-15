package com.wt.source.dao;

import com.wt.source.model.User;

/**
 * @author: wtt
 * @date: 2022/9/17 15:09
 * @description:
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

}
