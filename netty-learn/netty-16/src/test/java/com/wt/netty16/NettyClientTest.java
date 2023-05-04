package com.wt.netty16;

import com.wt.netty16.client.NettyClient;
import com.wt.netty16.domain.FileTransferProtocol;
import com.wt.netty16.util.MsgUtil;
import io.netty.channel.ChannelFuture;

import java.io.File;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/3 18:57
 */
public class NettyClientTest {
    public static void main(String[] args) {

        //启动客户端
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1", 7397);

        //文件信息{文件大于1024kb方便测试断点续传}
        File file = new File("D:\\测试传输文件.rar");
        FileTransferProtocol fileTransferProtocol = MsgUtil.buildRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());

        //发送信息；请求传输文件
        channelFuture.channel().writeAndFlush(fileTransferProtocol);

    }

}
