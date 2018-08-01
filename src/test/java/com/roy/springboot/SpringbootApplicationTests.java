package com.roy.springboot;

import com.roy.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext context;

	//记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {

		//日志的级别，由低到高，可以调整输出的日志级别：不需要注释，高级别的日志信息可以显示，低级别的就不在显示

		logger.trace("跟踪轨迹");

		logger.debug("调试信息");

		//SpringBoot默认的级别是Info级别
		logger.info("Info信息");

		logger.warn("警告信息");

		logger.error("错误信息");
	}

	@Test
	public void testHelloService(){
		boolean r = context.containsBean("helloService");
		System.out.println(r);
	}



}
