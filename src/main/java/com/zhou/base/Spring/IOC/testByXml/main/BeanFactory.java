package com.zhou.base.Spring.IOC.testByXml.main;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/1 15:19
 */
public interface BeanFactory {

    //核心方法getBean
    Object getBean(String name);
}
