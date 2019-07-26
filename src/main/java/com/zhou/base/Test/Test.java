package com.zhou.base.Test;

public class Test {

    public static void main(String args[]) {
        Child myC=new Child();
        myC.printall();
    }

}

class Parent{
    void printMe() {
        System.out.println("parent");
    }
}
class Child extends Parent {
    @Override
    void printMe() {
        System.out.println("child");
    }
    void printall() {
        super.printMe();
        this.printMe();
        printMe();
    }
}
