package com.wt.tmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/11 16:30
 */
@SpringBootApplication
@EnableFeignClients
public class Bootstrap {

    public static void main(String[] args) {
//        Utils.loadPropertySource(FeignAndRibbonController.class, "default.properties");
//        Utils.loadPropertySource(FeignAndRibbonController.class, "ribbon.properties");
        SpringApplication.run(Bootstrap.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
