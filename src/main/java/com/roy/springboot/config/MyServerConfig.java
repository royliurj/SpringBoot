package com.roy.springboot.config;

import com.roy.springboot.filter.MyFilter;
import com.roy.springboot.listener.MyListener;
import com.roy.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//注册三大组件
@Configuration
public class MyServerConfig {

    //注册Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),"/myServlet");

        return bean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));

        return bean;
    }

    //注册Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new MyListener());
        return bean;
    }
}
