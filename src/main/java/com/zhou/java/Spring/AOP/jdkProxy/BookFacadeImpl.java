package com.zhou.java.Spring.AOP.jdkProxy;

public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("添加书本");
    }

}
