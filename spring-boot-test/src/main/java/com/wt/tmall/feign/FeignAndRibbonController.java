package com.wt.tmall.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/12 20:47
 */
@RestController
@RequestMapping("feignandribbon")
@Slf4j
public class FeignAndRibbonController {

    @Autowired
    private Client client;

    @GetMapping("client")
    public void timeout() {
        long begin = System.currentTimeMillis();
        try {
            client.server();
        } catch (Exception ex) {
            log.warn("执行耗时：{}ms 错误：{}", System.currentTimeMillis() - begin, ex.getMessage());
        }
    }

    @PostMapping("/server")
    public void server() throws InterruptedException {
        TimeUnit.MINUTES.sleep(10);
    }
}
