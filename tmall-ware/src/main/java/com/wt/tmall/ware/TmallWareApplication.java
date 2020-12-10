package com.wt.tmall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wt.tmall.ware.dao")
@SpringBootApplication
public class TmallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallWareApplication.class, args);
	}

}
