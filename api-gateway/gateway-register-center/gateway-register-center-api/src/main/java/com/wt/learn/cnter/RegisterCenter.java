package com.wt.learn.cnter;

import com.sun.xml.internal.ws.api.server.ServiceDefinition;

/**
 * @Author: wtt
 * @Date: 2023/7/9 11:55
 * @Version: 1.0
 * @Description:
 */
public interface RegisterCenter {

    void init(String registerAddress, String env);

    String register(ServiceDefinition serviceDefinition);
}
