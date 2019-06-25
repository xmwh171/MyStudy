package com.zhou.base.Exception;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/6/24 12:42
 */
public class MyRuntimeException extends RuntimeException {

    public MyRuntimeException() {
    }

    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
