package com.uptool.core.Exception;

/**
 * @Description: 校验异常
 * @Author Vito.Chen
 * @Date 2021/3/4 10:54
 */
public class ValidationException extends CanThrowMessageException {


    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
