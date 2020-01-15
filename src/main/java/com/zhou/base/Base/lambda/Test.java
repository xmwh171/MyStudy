package com.zhou.base.Base.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/11/14 15:06
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1,9,6,8,3});
        Collections.sort(list,(a,b)->a.compareTo(b));
        System.out.println(list);
    }
}
