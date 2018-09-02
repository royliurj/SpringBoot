package com.roy.springbootmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootmqApplicationTests {


	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createExchange(){

		Exchange exchange = new DirectExchange("amqpadmin.exchange");
		//创建一个Exchange
		amqpAdmin.declareExchange(exchange);

		//创建一个Queue
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

		//创建绑定规则
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.hh",null));
	}


	@Test
	public void contextLoads() {

		//单播（点对点）
		//Message需要自己构造
		//rabbitTemplate.send(exchange,routingkey,message);

		//只需要传入要发送单对象，自动序列化
		//rabbitTemplate.convertAndSend(exchange,routingkey,object);

		Map<String,Object> map = new HashMap<>();
		map.put("msg","这是第一个消息");
		map.put("data", Arrays.asList("111",222,true));

		rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

		System.out.println("send message success");
	}

	@Test
	public void receive(){

		Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
		System.out.println(o.getClass());
		System.out.println(o);

	}
}
