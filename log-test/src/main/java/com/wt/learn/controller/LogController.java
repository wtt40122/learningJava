package com.wt.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/7/14 15:44
 */
@RestController
@Slf4j
public class LogController {

    @GetMapping("/log/print")
    public String printLog(int num) {
        for (int i = 0; i < num; i++) {
            log.info("我是日志的开发者：{}", i);
        }
        return "success";
    }

}
