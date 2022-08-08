package com.wt.mybatis.dao;


import com.wt.mybatis.annoations.Insert;
import com.wt.mybatis.annoations.Select;
import com.wt.mybatis.annoations.Update;
import com.wt.mybatis.pojo.User;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/1 14:23
 */
public interface IUserDao {

    @Select("SELECT id, userId, userName, userHead\n" +
            "FROM user\n" +
            "where id = #{id}")
    User queryUserInfoById(Long id);

    @Select("SELECT id, userId, userName, userHead\n" +
            "        FROM user\n" +
            "        where id = #{id}")
    User queryUserInfo(User req);

    @Select("SELECT id, userId, userName, userHead\n" +
            "FROM user")
    List<User> queryUserInfoList();

    @Update("UPDATE user\n" +
            "SET userName = #{userName}\n" +
            "WHERE id = #{id}")
    int updateUserInfo(User req);

    @Insert("INSERT INTO user\n" +
            "(userId, userName, userHead, createTime, updateTime)\n" +
            "VALUES (#{userId}, #{userName}, #{userHead}, now(), now())")
    void insertUserInfo(User req);

    @Insert("DELETE FROM user WHERE userId = #{userId}")
    int deleteUserInfoByUserId(String userId);
}
