package com.roy.springboot.component;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;

import java.util.Map;

//加入自己定义的属性
public class MyErrorAttributes  extends DefaultErrorAttributes{

//    @Override
//    public Map<String, Object> getErrorAttributes(org.springframework.web.reactive.function.server.ServerRequest request, boolean includeStackTrace) {
//        Map<String,Object> map = super.getErrorAttributes(request, includeStackTrace);
//
//        map.put("company","Roy");
//
//        return map;
//    }
}
