package com.roy.springboot.controller;

import com.roy.springboot.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String hello(@RequestParam("user") String user)
    {
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }

        return "Hello " + name;
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){

        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("roy1","adf","123213"));

        //classpath:templates/success.html
        return "success";
    }

//    //第一种方式，访问主页面，index.html必须放到templates文件夹下，返回值会按照规则拼接到具体到页面 templates/"返回值".html
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
