package com.wt.netty.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/3 19:54
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9998);
            IUserService userService = (IUserService) registry.lookup("userService");
            User user = userService.getByUserId(2);
            System.out.println(user.getId() + "-----" + user.getName());
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }
}
