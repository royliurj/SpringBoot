package com.roy.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * 一、搭建基本环境
 * 1, 创建javabean
 * 2，整合mybatis
 * 	1）配置数据
 * 	2) 注解版等mybatis
 * 		a, @MapperScan指定需要扫描等mapper接口所在的包
 *
 * 二、快速体验缓存
 * 1，开启基于注解的缓存 @EnableCaching
 * 2，标注缓存注解即可
 * 	@Cacheable
 * 	@CacheEvict
 * 	@CachePut
 */

@MapperScan("com.roy.springbootcache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}
}
