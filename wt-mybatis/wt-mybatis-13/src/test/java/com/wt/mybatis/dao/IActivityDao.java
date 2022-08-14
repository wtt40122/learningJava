package com.wt.mybatis.dao;


import com.wt.mybatis.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Long activityId);

}
