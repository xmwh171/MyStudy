package com.zhou.base.Base.reflection;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/26 15:30
 */
public class TestReflect implements Serializable {

    private static final long serialVersionUID = -2862585049955236662L;

    private String proprety = null;

    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }

    public static void main(String[] args) throws Exception {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();
        System.out.println();
        test8();
        System.out.println();
        test9();
        System.out.println();
        test10();
        System.out.println();
        test11();
    }


    /**
     * 通过一个对象获得完整的包名和类名
     */
    public static void test1(){
        TestReflect testReflect = new TestReflect();
        System.out.println(testReflect.getClass().getName());
    }

    /**
     * 实例化Class类对象
     * @throws Exception
     */
    public static void test2() throws Exception {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        class1 = Class.forName("com.zhou.base.Base.reflection.TestReflect");
        class2 = new TestReflect().getClass();
        class3 = TestReflect.class;
        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());
    }

    /**
     * 获取一个对象的父类与实现的接口
     * @throws Exception
     */
    public static void test3() throws Exception {
        Class<?> class1 = null;
        class1 = Class.forName("com.zhou.base.Base.reflection.User");
        // 第一种方法，实例化默认构造方法，调用set赋值
        User user = (User) class1.newInstance();
        user.setAge(20);
        user.setName("Rollen");
        System.out.println(user);
        // 第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
        user = (User) cons[0].newInstance(20,"Rollen");
        System.out.println(user);
        user = (User) cons[1].newInstance( "Rollen");
        System.out.println(user);
    }

    /**
     * 获取某个类的全部属性
     * @throws Exception
     */
    public static void test4() throws Exception {
        Class<?> clazz = Class.forName("com.zhou.base.Base.reflection.TestReflect");
        System.out.println("===============本类属性===============");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    /**
     * 获取某个类的全部方法
     * @throws Exception
     */
    public static void test5() throws Exception {
        Class<?> clazz = Class.forName("com.zhou.base.Base.reflection.TestReflect");
        Method method[] = clazz.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }


    /**
     * 通过反射机制调用某个类的方法
     * @throws Exception
     */
    public static void test6() throws Exception {
        Class<?> clazz = Class.forName("com.zhou.base.Base.reflection.TestReflect");
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "张三");
    }

    /**
     * 通过反射机制操作某个类的属性
     * @throws Exception
     */
    public static void test7() throws Exception {
        Class<?> clazz = Class.forName("com.zhou.base.Base.reflection.TestReflect");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));

    }

    /**
     * 在泛型为Integer的ArrayList中存放一个String类型的对象
     * @throws Exception
     */
    public static void test8() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, "Java反射机制实例。");
        System.out.println(list.get(0));
    }

    /**
     * 通过反射取得并修改数组的信息
     */
    public static void test9(){
        int[] temp = { 1, 2, 3, 4, 5 };
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }

    /**
     * 通过反射机制修改数组的大小
     */
    public static void test10(){
        int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] newTemp = (int[]) arrayInc(temp, 15);
        print(newTemp);
        String[] atr = { "a", "b", "c" };
        String[] str1 = (String[]) arrayInc(atr, 8);
        print(str1);
    }

    // 修改数组大小
    public static Object arrayInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }
    // 打印
    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组长度为： " + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
        System.out.println();
    }

    /**
     * 测试类装载继承关系
     */
    public static void test11(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前类classLoad："+loader);
        System.out.println("父类："+loader.getParent());
        System.out.println("祖父类："+loader.getParent().getParent());
    }


}


class User {
    private int age;
    private String name;
    public User() {
        super();
    }
    public User(String name) {
        super();
        this.name = name;
    }
    public User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}
