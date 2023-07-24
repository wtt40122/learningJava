package com.wt.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/7/14 15:15
 */
@SpringBootApplication
@Slf4j
public class BootStrap {
    public static void main(String[] args) {
        log.info("os name:{}", System.getProperty("os.name").toLowerCase());
        SpringApplication.run(BootStrap.class, args);
        long initDelay = 0;
        long intervalTime = 1;
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> log.info("I am health,time:{}", LocalDateTime.now()), initDelay, intervalTime, TimeUnit.SECONDS);

    }
}
