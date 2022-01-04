package com.wt.tmall.rpc.consumer;

import com.wt.tmall.rpc.consumer.proxy.RpcClientProxy;
import com.wt.tmall.rpc.api.IUserService;
import com.wt.tmall.rpc.pojo.User;

/**
 * 测试类
 */
public class ClientBootStrap {
    public static void main(String[] args) {
        IUserService userService = (IUserService) RpcClientProxy.createProxy(IUserService.class);
        User user = userService.getById(1);
        System.out.println(user);
    }
}
