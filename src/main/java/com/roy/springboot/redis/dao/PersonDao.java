package com.roy.springboot.redis.dao;

import com.roy.springboot.redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDao {

    //注入StringRedisTemplate
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //指定stringRedisTemplate，可注入基于字符串的简单属性操作方法
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    //注入RedisTemplate
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    //指定redisTemplate，注入基于对象的简单属性操作方法
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }

    public void save(Person person){
        valOps.set(person.getId(), person);
    }

    public String getString(){
        return valOpsStr.get("xx");
    }

    public Person getPerson(){
        return (Person) valOps.get("1");
    }
}
