package com.roy.springboot.redis.controller;

import com.roy.springboot.redis.dao.PersonDao;
import com.roy.springboot.redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/set")
    public void set(){
        Person person = new Person(1,"Roy",33);

        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){

        return personDao.getPerson();
    }
}
