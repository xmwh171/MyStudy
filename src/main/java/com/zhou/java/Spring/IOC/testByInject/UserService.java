package com.zhou.java.Spring.IOC.testByInject;

/**
 * @Description 用户Service实现
 * @Author xiaohu
 * @Date 2019/8/5 12:50
 */
@Component
public class UserService {
    public User getUser() {
        User user = new User("张三", 20);
        return user;
    }
}
