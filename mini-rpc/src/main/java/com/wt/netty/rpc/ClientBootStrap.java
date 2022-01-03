package com.wt.netty.rpc;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/3 23:08
 */
public class ClientBootStrap {
    public static void main(String[] args) {
        IUserService userService = (IUserService) RpcClientProxy.createProxy(IUserService.class);
        User user = userService.getById(1);
        System.out.println(user);
    }
}
