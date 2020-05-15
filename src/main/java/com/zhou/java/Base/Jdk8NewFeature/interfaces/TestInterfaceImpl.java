package com.zhou.java.Base.Jdk8NewFeature.interfaces;

/**
 * @Description
 * 实现多个接口的default方法时，不能方法名和参数名都相同，不然编辑时会报错
 * @Author xiaohu
 * @Date 2020/5/15 10:40
 */
public class TestInterfaceImpl implements TestInterface,TestInterface2 {

    @Override
    public void test() {

    }

    public static void main(String[] args) {
        TestInterfaceImpl impl = new TestInterfaceImpl();
        System.out.println(TestInterface.a);
        System.out.println(impl.d1());
        System.out.println(impl.d2());
        System.out.println(TestInterface.s1());
        System.out.println(TestInterface.s2());
    }


}
