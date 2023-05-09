package com.wt.netty.rpc.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/9 9:47
 */
public class SyncWriteMap {

    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<String, WriteFuture>();
}
