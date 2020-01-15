package com.zhou.base.Base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/8 15:18
 */
public class Test {


    public static void main(String[] args) {

        Map mainMap = new HashMap();
        mainMap.put("KDLX","9");

        String kjnx = (
                (String)mainMap.get("KDLX")).equals("5") ? "天天快递" : (((String)mainMap.get("KDLX")).equals("111") ? "新增快递" : (((String)mainMap.get("KDLX")).equals("6") ?"圆通快递" : (((String)mainMap.get("KDLX")).equals("9") ? "邮政小包" : (((String)mainMap.get("KDLX")).equals("7") ? "汇通快递" : (((String)mainMap.get("KDLX")).equals("8") ? "申通快递" : (((String)mainMap.get("KDLX")).equals("11") ? "中通快递" : (((String)mainMap.get("KDLX")).equals("10") ? "韵达快递" : (((String)mainMap.get("KDLX")).equals("0") ? "顺丰次日" : (((String)mainMap.get("KDLX")).equals("12") ? "顺丰次日_到付" : (((String)mainMap.get("KDLX")).equals("13") ? "顺丰隔日" : ((

                (String)mainMap.get("KDLX")).equals("14") ? "顺丰隔日_到付" : "")
        )))))))))

        );


        System.out.println(kjnx);
    }



}
