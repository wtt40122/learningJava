package com.wt.netty21.redis;

import com.wt.netty21.domain.MsgAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:58
 */
@Service
public class Publisher {
    private final RedisTemplate<String, Object> redisMessageTemplate;

    @Autowired
    public Publisher(RedisTemplate<String, Object> redisMessageTemplate) {
        this.redisMessageTemplate = redisMessageTemplate;
    }

    public void pushMessage(String topic, MsgAgreement message) {
        redisMessageTemplate.convertAndSend(topic, message);
    }
}
