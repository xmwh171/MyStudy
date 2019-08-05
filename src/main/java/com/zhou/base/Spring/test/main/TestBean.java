package com.zhou.base.Spring.test.main;

import org.junit.Test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/1 15:19
 */
public class TestBean {

    @Test
    public void func1(){

        BeanFactory bf = (BeanFactory) new ClassPathXmlApplicationContext("E:\\study\\MyStudy\\src\\main\\resource\\applicationContext.xml");
        Person s=(Person)bf.getBean("person");
        Person s1=(Person)bf.getBean("person");
        System.out.println(s==s1);
        System.out.println(s1);
        Student stu1=(Student) bf.getBean("student");
        Student stu2=(Student) bf.getBean("student");
        String name=stu1.getName();
        System.out.println(name);
        System.out.println(stu1==stu2);
    }
}
