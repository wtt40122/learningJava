package com.wt.netty.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/3 19:48
 */
public class RMIServer {
    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(9998);
            IUserService userService = new UserServiceImpl();
            registry.rebind("userService", userService);
            System.out.println("RMI 服务器启动成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
