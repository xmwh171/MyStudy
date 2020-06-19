package com.zhou.java.Spring.AOP.jdkProxy;

import com.zhou.java.Spring.AOP.jdkProxy.BookFacade;
import com.zhou.java.Spring.AOP.jdkProxy.BookFacadeImpl;
import com.zhou.java.Spring.AOP.jdkProxy.BookFacadeProxy;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestProxy {

    public static void main(String[] args) throws Exception {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.getInstance(new BookFacadeImpl());
        bookProxy.addBook();


        // 获取字节码内容
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{BookFacade.class});
        FileOutputStream os = new FileOutputStream("E:\\study\\MyStudy\\src\\main\\java\\com\\zhou\\java\\Spring\\AOP\\jdkProxy\\$Proxy.class");
        os.write(data);
        os.close();

    }
}
