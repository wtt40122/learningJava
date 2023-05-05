package com.wt.netty21.domain;

import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description 服务端信息
 * @date 2023/5/5 9:42
 */
public class ServerInfo {
    private String ip;
    private int port;
    private Date openDate;

    public ServerInfo(String ip, int port, Date openDate) {
        this.ip = ip;
        this.port = port;
        this.openDate = openDate;
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

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
