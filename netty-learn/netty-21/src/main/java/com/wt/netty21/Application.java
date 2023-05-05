package com.wt.netty21;

import com.wt.netty21.redis.RedisUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 10:05
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Resource
    private RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        redisUtil.clear();
    }
}
