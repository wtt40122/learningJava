package com.wt.netty.rpc.network.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 9:51
 */
public class SyncWriteMap {
    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<String, WriteFuture>();
}
