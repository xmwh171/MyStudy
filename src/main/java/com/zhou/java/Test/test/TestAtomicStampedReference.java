package com.zhou.java.Test.test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description 测试AtomicStampedReference机制
 * @Author xiaohu
 * @Date 2021/3/8 15:05
 */
public class TestAtomicStampedReference {


    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "bbb";
        AtomicStampedReference<String> reference = new AtomicStampedReference<String>(str1,1);
        reference.compareAndSet(str1,str2,reference.getStamp(),reference.getStamp()+1);
        System.out.println("reference.getReference() = " + reference.getReference());

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);
        System.out.println("b: "+b);
        System.out.println("reference.getStamp() = "+reference.getStamp());
        // 此处expectedStamp内存中是3，所以cas不成功
        boolean c = reference.weakCompareAndSet(str2,"ccc",4, reference.getStamp()+1);
        System.out.println("reference.getReference() = "+reference.getReference());
        System.out.println("c = " + c);

    }
}
