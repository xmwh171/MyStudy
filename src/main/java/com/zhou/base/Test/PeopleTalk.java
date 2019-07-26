package com.zhou.base.Test;

/**
 * @Description 真实主题角色：定义真实的对象
 * @Author xiaohu
 * @Date 2019/7/24 17:47
 */
public class PeopleTalk {

    public String username;
    public String age;

    public PeopleTalk(String username, String age) {
        this.username = username;
        this.age = age;
    }

    public PeopleTalk() {

    }

    public void talk(String msg) {
        System.out.println(msg + "!你好,我是" + username + "，我年龄是" + age);
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
