package com.wt.tmall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/12 18:46
 */
@RestController
@Slf4j
public class RedisController {


    @PostConstruct
    public void init() {
        try (Jedis jedis = new Jedis("127.0.0.1", 6379)) {
            Assert.isTrue("OK".equals(jedis.set("a", "1")), "set a = 1 return OK");
            Assert.isTrue("OK".equals(jedis.set("b", "2")), "set b = 2 return OK");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            jedisPool.close();
        }));
    }

    @GetMapping("/redis/test/wrong")
    public String testRedisWrong() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                String result = jedis.get("a");
                if (!result.equals("1")) {
                    log.warn("Expect a to be 1 but found {}", result);
                    return;
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                String result = jedis.get("b");
                if (!result.equals("2")) {
                    log.warn("Expect b to be 2 but found {}", result);
                    return;
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(5);
        return "success";
    }

    private static JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);

    @GetMapping("/redis/test/right")
    private String testRedisRight() {
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                for (int i = 0; i < 1000; i++) {
                    String result = jedis.get("a");
                    if (!result.equals("1")) {
                        log.warn("Expect a to be 1 but found {}", result);
                        return;
                    }
                }
            }
        }).start();
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                for (int i = 0; i < 1000; i++) {
                    String result = jedis.get("b");
                    if (!result.equals("2")) {
                        log.warn("Expect b to be 2 but found {}", result);
                        return;
                    }
                }
            }
        }).start();
        return "success";
    }

}
