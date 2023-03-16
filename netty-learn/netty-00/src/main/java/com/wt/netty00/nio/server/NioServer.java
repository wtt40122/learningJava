package com.wt.netty00.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/16 10:41
 */
public class NioServer {
    private Selector selector;
    private ServerSocketChannel socketChannel;

    public static void main(String[] args) {
        new NioServer().bind(7397);
    }

    public void bind(int port) {
        try {
            selector = Selector.open();
            socketChannel = ServerSocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.socket().bind(new InetSocketAddress(port), 1024);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println(" nio server start done.");
            new NioServerHandler(selector, Charset.forName("GBK")).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
