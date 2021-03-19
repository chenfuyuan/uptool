package com.uptool.core.Exception;

/**
 * @Description: 参数为空异常
 * @Author chenfuyuan
 * @Date 2021/3/19 16:33
 */
public class ArgumentEmptyException extends RuntimeException {

    public ArgumentEmptyException() {
        super("参数为空;");
    }

    public ArgumentEmptyException(String message) {
        super(message);
    }

}
