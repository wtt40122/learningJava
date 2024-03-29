package com.wt.tmall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.wt.tmall.coupon.dao")
@SpringBootApplication
public class TmallCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallCouponApplication.class, args);
	}

}
