package com.uptool.core.Exception;

/**
 * @Description: 匹配不到对象类型异常
 * @Author: chenfuyuan
 * @Date: 2021/3/31 20:05
 */
public class MatchNoSuchClassException extends RuntimeException {

    public MatchNoSuchClassException() {
        super("匹配不到对应类型;");
    }

    public MatchNoSuchClassException(String message) {
        super(message);
    }
}
