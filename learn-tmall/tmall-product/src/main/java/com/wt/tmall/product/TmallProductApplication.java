package com.wt.tmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.wt.tmall.product.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class TmallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallProductApplication.class, args);
	}

}
