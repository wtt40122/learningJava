package com.wt.netty21.util;

import com.wt.netty21.domain.ServerInfo;
import com.wt.netty21.server.NettyServer;
import io.netty.channel.Channel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:55
 */
public class CacheUtil {
    // 缓存channel
    public static Map<String, Channel> cacheChannel = Collections.synchronizedMap(new HashMap<String, Channel>());

    // 缓存服务信息
    public static Map<Integer, ServerInfo> serverInfoMap = Collections.synchronizedMap(new HashMap<Integer, ServerInfo>());

    // 缓存服务端
    public static Map<Integer, NettyServer> serverMap = Collections.synchronizedMap(new HashMap<Integer, NettyServer>());

}
