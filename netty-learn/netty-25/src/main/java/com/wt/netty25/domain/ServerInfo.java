package com.wt.netty25.domain;

import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/17 18:38
 */
public class ServerInfo {
    private String typeInfo;//服务类型
    private String ip;      //IP
    private int port;       //端口
    private Date openDate;  //启动时间

    public String getTypeInfo() {
        return typeInfo;
    }

    public ServerInfo(String typeInfo, String ip, int port, Date openDate) {
        this.typeInfo = typeInfo;
        this.ip = ip;
        this.port = port;
        this.openDate = openDate;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
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
