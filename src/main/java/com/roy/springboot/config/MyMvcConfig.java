package com.roy.springboot.config;

import com.roy.springboot.component.LoginHandlerInterceptor;
import com.roy.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/hello2").setViewName("success");
    }

    //第二种方式
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
//            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //静态资源：css，js
//                //SpringBoot已经做好了静态资源到映射
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
//            }

            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");


            }
        };

        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
