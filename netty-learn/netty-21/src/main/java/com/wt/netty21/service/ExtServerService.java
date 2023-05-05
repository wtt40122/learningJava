package com.wt.netty21.service;

import com.wt.netty21.domain.MsgAgreement;
import com.wt.netty21.redis.Publisher;
import com.wt.netty21.redis.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:47
 */
@Service
public class ExtServerService {
    @Resource
    private Publisher publisher;
    @Resource
    private RedisUtil redisUtil;

    public void push(MsgAgreement msgAgreement) {
        publisher.pushMessage("netty-push-msgAgreement", msgAgreement);
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }
}
