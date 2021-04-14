package com.zhou.java.Test.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xiaohu
 * @Date 2021/1/14 16:49
 */
public class Test {


    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(8);
        map.put("1","2");
        map.put("12","2");
        System.out.println(map.size());
    }
}
