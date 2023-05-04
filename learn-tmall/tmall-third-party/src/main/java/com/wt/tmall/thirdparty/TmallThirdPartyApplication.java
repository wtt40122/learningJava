package com.wt.tmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: wtt
 * @Date: 2021/1/12 13:03
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class TmallThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmallThirdPartyApplication.class, args);
    }
}
