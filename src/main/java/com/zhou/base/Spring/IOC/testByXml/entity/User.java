package com.zhou.base.Spring.IOC.testByXml.entity;

import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/9 9:35
 */
@Configuration
public class User {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
