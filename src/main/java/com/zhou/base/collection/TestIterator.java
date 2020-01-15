package com.zhou.base.collection;

import java.util.*;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/11/18 13:19
 */
public class TestIterator {


    public static void main(String[] args) {
       // deleteTest();
        test1();
    }


    /**
     * 注意it.remove()删除的是最近的一次it.next()获取的元素，而不是当前iterator中游标指向的元素！！
     * 因此，本例中i==2时，删除的其实是bbbbbb，而不是cccccc，这很容易被忽视或者误解。
     * 如果想删掉cccccc,正确操作是先调用it.next()获取到具体元素，再判断；而且由于调用了it.next(),此时游标已经指向我们期望删除的值了。
     * 想直接数数字进行删除，在这里会容易出错误。
     */
    public static void deleteTest(){
        List<String> list = new ArrayList();
        list.add("aaaaaa");
        list.add("bbbbbb");
        list.add("cccccc");
        list.add("dddddd");
        list.add("eeeeee");

        Iterator it = list.iterator();
        int i = 0;
        String s = null;
        while(it.hasNext()){
            if(i==2){
//                list.remove(it.next());
                it.remove();// 如果用list.remove(it.next());会报异常
            }
            System.out.println("第"+i+"个元素"+it.next());
            i++ ;
        }
        System.out.println("----------------");
        Iterator it2 = list.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }


    public static void test1(){
        List<Double> list = new ArrayList();
        list.add(1d);
        list.add(2d);
        Map<String, Double> checkMap = new HashMap<>();
        checkMap.put("2",2d);
        Iterator<Double> wdtTradeInfoIterator = list.iterator();
        while (wdtTradeInfoIterator.hasNext()) {
            Double number = wdtTradeInfoIterator.next();
            Double totalNum = checkMap.get("1");
            if (totalNum == null || totalNum == 0) {
                wdtTradeInfoIterator.remove();
            } else  {
                System.out.println(number);
            }
        }
        Iterator it2 = list.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
