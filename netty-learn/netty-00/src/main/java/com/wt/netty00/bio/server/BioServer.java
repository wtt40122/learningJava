package com.wt.netty00.bio.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 10:37
 */
public class BioServer extends Thread {
    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        bioServer.start();
    }


    @Override
    public synchronized void start() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(7397));
            System.out.println("netty bio server start done");
            while (true) {
                Socket socket = serverSocket.accept();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
