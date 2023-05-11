package com.wt.netty.rpc.domain;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/11 10:21
 */
public class Hi {
    private String userName;
    private String sayMsg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSayMsg() {
        return sayMsg;
    }

    public void setSayMsg(String sayMsg) {
        this.sayMsg = sayMsg;
    }
}
