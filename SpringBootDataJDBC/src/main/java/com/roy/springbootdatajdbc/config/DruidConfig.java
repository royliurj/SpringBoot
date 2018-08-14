package com.roy.springbootdatajdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        //配置StatViewServlet需要的参数
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");//默认允许所有

        registrationBean.setInitParameters(map);
        return registrationBean;
    }

    //2、配置一个Web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid");
        bean.setInitParameters(map);
        //拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
