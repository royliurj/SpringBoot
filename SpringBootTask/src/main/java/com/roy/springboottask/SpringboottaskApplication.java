package com.roy.springboottask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开始异步注解功能
@EnableAsync
//开始基于注解到定时任务
@EnableScheduling
@SpringBootApplication
public class SpringboottaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottaskApplication.class, args);
	}
}
