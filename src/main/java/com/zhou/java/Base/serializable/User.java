package com.zhou.java.Base.serializable;

import java.io.Serializable;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/9/10 16:41
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
