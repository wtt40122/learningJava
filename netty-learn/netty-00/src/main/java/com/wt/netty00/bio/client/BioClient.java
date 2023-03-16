package com.wt.netty00.bio.client;

import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 10:55
 */
public class BioClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 7397);
            System.out.println("wtt bio client start done");
            BioClientHandler clientHandler = new BioClientHandler(socket, Charset.forName("utf-8"));
            clientHandler.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
