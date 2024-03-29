package com.wt.netty.rpc.config;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:27
 */
public class ServerConfig {
    protected String host;  //注册中心地址
    protected int port;     //注册中心端口

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
