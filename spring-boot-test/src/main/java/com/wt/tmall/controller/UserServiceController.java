package com.wt.tmall.controller;

import com.wt.tmall.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/24 9:56
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserServiceController {
    @GetMapping
    public User getUser(@RequestParam("userId") long id) {
        //一半概率返回正确响应，一半概率抛异常
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            return new User(id, "name" + id);
        } else {
            throw new RuntimeException("error");
        }
    }
}
