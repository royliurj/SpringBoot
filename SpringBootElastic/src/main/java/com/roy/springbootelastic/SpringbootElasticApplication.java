package com.roy.springbootelastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持2中技术和ES交互
 * 1、Jest （默认不生效）
 * 2、SpringData ES
 */
@SpringBootApplication
public class SpringbootElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElasticApplication.class, args);
	}
}
