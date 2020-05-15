package com.zhou.java.Spring.AOP;

import com.zhou.java.Spring.AOP.aspectjMethod.Business;
import com.zhou.java.Spring.AOP.interfaceMethod.IBaseBusiness;
import com.zhou.java.Spring.AOP.schemaMethod.AspectBusiness;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/24 18:59
 */
public class Test {

    public static void main(String[] args) {
       //  testAop();
      //  testAspectAop();
        testAspectj();
    }

    public static void testAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/schema_aop.xml");
        IBaseBusiness business = (IBaseBusiness) context.getBean("businessProxy");
        business.delete("猫");
    }

    public static void testAspectAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/schema_aspect_aop.xml");
        AspectBusiness business = (AspectBusiness) context.getBean("aspectBusiness");
        business.delete("猫");
    }


    public static void testAspectj(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/aspectj_aop.xml");
        Business business = (Business) context.getBean("business");
        business.delete("猫");
    }
}
