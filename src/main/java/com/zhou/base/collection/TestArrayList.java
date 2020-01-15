package com.zhou.base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/11/18 10:15
 */
public class TestArrayList {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int count = 12;
        for(int i=0;i<count;i++){
            list.add(i);
        }
    }

}
