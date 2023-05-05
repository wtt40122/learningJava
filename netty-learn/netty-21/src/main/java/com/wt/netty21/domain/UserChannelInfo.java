package com.wt.netty21.domain;

import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description 用户管道信息, 记录某个用户分配到某个服务器
 * @date 2023/5/5 9:44
 */
public class UserChannelInfo {
    private String ip;
    private int port;
    private String channelId;
    private Date linkDate;

    public UserChannelInfo(String ip, int port, String channelId, Date linkDate) {
        this.ip = ip;
        this.port = port;
        this.channelId = channelId;
        this.linkDate = linkDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(Date linkDate) {
        this.linkDate = linkDate;
    }
}
