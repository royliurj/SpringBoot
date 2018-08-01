package com.roy.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @Value("${person.name}")
    private String name;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello " + name;
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){

        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("roy1","adf","123213"));

        //classpath:templates/success.html
        return "success";
    }
}
