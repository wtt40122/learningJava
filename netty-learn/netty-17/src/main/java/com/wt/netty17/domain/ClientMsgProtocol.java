package com.wt.netty17.domain;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 9:20
 */
public class ClientMsgProtocol {
    private int type;       //1请求个人信息，2发送聊天信息
    private String msgInfo; //消息

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
