package com.wt.tmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TmallOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallOrderApplication.class, args);
	}

}
