package com.roy.springboot.controller;

import com.roy.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionController {

//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    public Map<String,Object> handleException(Exception e){
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException2(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        //传入自己的错误状态码 4xx 5xx
        request.setAttribute("javax.servlet.error.status_code",400);

        //设置map到ext中
        request.setAttribute("ext",map);

        //转发到/error，进行自适应处理
        return "forward:/error";
    }
}
