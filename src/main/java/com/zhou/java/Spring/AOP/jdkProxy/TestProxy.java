package com.zhou.java.Spring.AOP.jdkProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class TestProxy {

    public static void main(String[] args) throws Exception {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.getInstance(new BookFacadeImpl());
        bookProxy.addBook();

        // 获取字节码内容
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy1",new Class[]{BookFacade.class});
        FileOutputStream os = new FileOutputStream("E:\\study\\MyStudy\\src\\main\\java\\com\\zhou\\java\\Spring\\AOP\\jdkProxy\\$Proxy1.class");
        os.write(data);
        os.close();
    }
}
