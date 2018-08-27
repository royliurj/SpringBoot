package com.roy.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 搭建基本环境
 * 1, 创建javabean
 * 2，整合mybatis
 * 	1）配置数据
 * 	2) 注解版等mybatis
 * 		a, @MapperScan指定需要扫描等mapper接口所在等包
 */

@MapperScan("com.roy.springbootcache.mapper")
@SpringBootApplication
public class SpringbootcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}
}
