package com.wt.mybatis.po;

import java.util.Date;

/**
 * @author: wtt
 * @date: 2022/7/31 20:19
 * @description:
 */
public class Company {
    private Long id;
    private String userId;          // 用户ID
    private String userHead;        // 头像
    private Date createTime;        // 创建时间
    private Date updateTime;        // 更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
