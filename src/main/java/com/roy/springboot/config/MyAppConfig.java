package com.roy.springboot.config;

import com.roy.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration指定当前类是一个配置类，替代spring的配置文件
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中；容器中的这个组件，默认的id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("========add ========");
        return new HelloService();
    }
}
