package com.roy.springbootmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TestService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(HashMap<String,Object> map){

        System.out.println("收到消息：" + map);
    }
}
