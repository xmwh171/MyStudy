package com.zhou.java.Exception;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/6/24 12:36
 */
public class MyException extends Exception {

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
