package com.wt.tmall.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/12 20:44
 */
@FeignClient(name = "clientsdk")
public interface Client {
    @GetMapping("/feignandribbon/server")
    String server();
}
