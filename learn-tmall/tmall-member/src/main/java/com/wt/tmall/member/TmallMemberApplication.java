package com.wt.tmall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.wt.tmall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wt.tmall.member.dao")
public class TmallMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallMemberApplication.class, args);
	}

}
