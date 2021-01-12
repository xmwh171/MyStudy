package com.zhou.java.DesignPattern.Prototype;

import java.io.*;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 10:48
 */
public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException{
        DeepPerson dc1 = new DeepPerson();
        // 对dc1赋值
        dc1.setA(100);
        dc1.setB(new int[] { 1000 });
        System.out.println("克隆前dc1: a=" + dc1.getA()+" b[0]=" + dc1.getB()[0]);
        DeepPerson dc2 = (DeepPerson) deepClone(dc1);
        // 对c2进行修改
        dc2.setA(50);
        int[] a = dc2.getB();
        a[0] = 500;
        System.out.println("克隆后dc1: a=" + dc1.getA()+" b[0]=" + dc1.getB()[0]);
        System.out.println("克隆后dc2: a=" + dc2.getA()+" b[0]=" + dc2.getB()[0]);
    }

    public static Object deepClone(Object object){
        Object o=null;
        try{
            if (object != null){
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                oos.close();
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                o = ois.readObject();
                ois.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
