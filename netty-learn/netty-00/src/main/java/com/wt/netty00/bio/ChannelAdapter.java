package com.wt.netty00.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 10:41
 */
public abstract class ChannelAdapter extends Thread {
    private Socket socket;
    private ChannelHandler channelHandler;
    private Charset charset;


    public ChannelAdapter(Socket socket, Charset charset) {
        this.socket = socket;
        this.charset = charset;
        while (!socket.isConnected()) {
            break;
        }
        channelHandler = new ChannelHandler(this.socket, charset);
        channelActive(channelHandler);
    }

    @Override
    public void start() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), charset));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                channelRead(channelHandler, str);
            }
        } catch (Exception e) {

        }
    }

    // 读取消息抽象类
    protected abstract void channelRead(ChannelHandler channelHandler, Object msg);

    //链接通知抽象类
    protected abstract void channelActive(ChannelHandler channelHandler);

}
