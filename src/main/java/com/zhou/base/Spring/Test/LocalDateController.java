package com.zhou.base.Spring.Test;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/6 11:10
 */
@RestController
public class LocalDateController {

    /**
     *  java8.0时间与日期API
     * @param localDate
     * @return
     */
    @RequestMapping("/data/{localDate}")
    public String get(@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)LocalDate localDate){
        return localDate.toString();
    }

    /**
     * Optional 代表可以忽略
     * @param username
     * @return
     */
    @RequestMapping("/optional")
    public String test(Optional<String> username){
        return "Java Optional";
    }

}


