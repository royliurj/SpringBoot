package com.roy.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的值，映射到组件中
 * @ConfigurationProperties : 告诉SpringBoot将本类中的所有属性和配置文件中的配置进行绑定
 * prefix = "person" 将配置文件中那个配置下的所有属性进行绑定
 *
 * 只有这个组件是容器中的组件，才能提供这个功能
 */
@Component
//@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

    /**
     * 等同于
     * <bean class="person">
     *  <property name="name" value="字面量、${key}(从环境变量、配置文件中获取)、#{SpEL}"></property>
     * </bean>
     */
//    @Value("${person.name}")

//    @Email
    private String name;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("false")
    private Boolean boss;
    private Date birth;

//    @Value("${person.maps}")
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
