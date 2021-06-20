package com.uptool.core.util;

/**
 * @Description: 断言工具类
 * @Author: chenfuyuan
 * @Date: 2021/6/14 13:06
 */
public class AssertUtil {

    /**
     * 校验是否包含文本内容
     * @param text 内容
     * @param msg 当不包含文本内容时，提示该消息
     * @throws IllegalArgumentException 参数异常
     */
    public static void hasText(String text,String msg) {
        if (!StringUtil.hasText(text)) {
            throw new IllegalArgumentException(msg);
        }
    }

}
