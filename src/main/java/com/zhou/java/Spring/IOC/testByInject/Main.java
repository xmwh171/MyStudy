package com.zhou.java.Spring.IOC.testByInject;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/5 12:52
 */
public class Main {

    public static void main(String[] args) throws Exception {
     // test();
      test2();
    }

    /**
     * 测试未加bean注解和属性注解
     * @throws Exception
     */
    public static void test() throws Exception {
        UserController userController = (UserController)IocContext.applicationContext.get(UserController.class);
        userController.getUser();
        userController.testNoAnnotation();
        userController.testNoInject();
    }

    /**
     * 测试未加属性注解但已注入bean时，手动注入属性
     * @throws Exception
     */
    public static void test2() throws Exception {
        UserController userController = (UserController)IocContext.applicationContext.get(UserController.class);
        userController.getUser();
        userController.testInject();
    }
}
