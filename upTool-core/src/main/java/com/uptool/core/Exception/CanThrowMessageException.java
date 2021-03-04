package com.uptool.core.Exception;

/**
 * @Description: 可以抛出错误信息的异常
 * @Author Vito.Chen
 * @Date 2021/3/4 10:55
 */
public class CanThrowMessageException extends Exception{

    public CanThrowMessageException() {
    }

    public CanThrowMessageException(String message) {
        super(message);
    }

    public CanThrowMessageException(String message, Throwable cause) {
        super(message, cause);
    }

}
