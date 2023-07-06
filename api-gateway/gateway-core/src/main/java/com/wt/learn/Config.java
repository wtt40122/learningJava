package com.wt.learn;

import lombok.Data;

/**
 * @Author: wtt
 * @Date: 2023/7/6 22:46
 * @Version: 1.0
 * @Description:
 */
@Data
public class Config {

    private int port = 8888;

    private String applicationName = "api-gateway";

    private String registryAddress = "127.0.0.1:8848";

    private String env = "dev";

    private int eventLoopGroupBossNum = 1;

    private int eventLoopGroupWorkerNum = Runtime.getRuntime().availableProcessors();

    private int maxContentLength = 64 * 1024 * 1024;

    private boolean whenComplete = true;

    //扩展

}