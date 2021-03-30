package com.uptool.core.Exception;

/**
 * @Description: 未实现方法异常
 * @Author: chenfuyuan
 * @Date: 2021/3/29 15:24
 */
public class NoImplementMethodException extends RuntimeException{

    public NoImplementMethodException() {
        super("方法未实现异常;");
    }

    public NoImplementMethodException(String message) {
        super(message);
    }
}
