package com.wt.algorithm.cache;

import java.util.LinkedHashMap;

/**
 * @Auther: wtt
 * @Date: 2021/5/4 14:55
 * @Description: 缓存过期策略
 */
public interface ExpireStrategy<K, V> {
    /**
     * 清空过期Key-Value
     *
     * @param localCache 本地缓存底层使用的存储结构
     * @param key 缓存的键
     * @return 过期的值
     */
    V removeExpireKey(LinkedHashMap<K, CacheNode<K, V>> localCache, K key);
}
