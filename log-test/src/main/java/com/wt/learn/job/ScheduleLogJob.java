package com.wt.learn.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/7/14 15:19
 */
@Component
@Slf4j
public class ScheduleLogJob {

    @Scheduled(cron = "0 1/2 * * * ?")
    public void logPrint() {
        log.info("ScheduleLogJob,HeraAppEnvIpJob execute！ time:{}", LocalDateTime.now());
    }

}
