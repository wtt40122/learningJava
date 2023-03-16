package com.wt.netty00.nio.clinet;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/16 10:31
 */
public class NioClient {

    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        boolean isConnect = socketChannel.connect(new InetSocketAddress("127.0.0.1", 7397));
        if (isConnect) {
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        System.out.println("nio client start done.");
        new NioClientHandler(selector, Charset.forName("GBK")).start();
    }
}
