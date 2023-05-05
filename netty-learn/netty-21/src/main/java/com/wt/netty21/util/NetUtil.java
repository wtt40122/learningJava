package com.wt.netty21.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:56
 */
public class NetUtil {
    public static int getPort() {
        int initPort = 7397;
        while (true) {
            if (!isPortUsing(initPort)) {
                break;
            }
            initPort++;
        }
        return initPort;
    }

    public static boolean isPortUsing(int port) {
        boolean flag = false;
        try {
            Socket socket = new Socket("localhost", port);
            socket.close();
            flag = true;
        } catch (IOException e) {

        }
        return flag;
    }

    public static String getHost() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(getHost());
    }

}
