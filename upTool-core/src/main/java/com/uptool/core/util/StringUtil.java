package com.uptool.core.util;

/**
 * @Description: 字符串工具类
 * @Author Vito.Chen
 * @Date 2021/2/12 11:18
 */
public class StringUtil {

    /**
     * 字符串 'null'
     */
    public static String STRING_NULL = "null";

    /**
     * 空字符串
     */
    public static String STRING_EMPTY = "";

    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return 字符串是否为空
     */
    public static boolean isEmpty(String str) {
        return "".equals(str) || str == null;
    }

    /**
     * 判断是否包含文本
     * @param str 字符串
     * @return 字符串是否包含文本，是:true,否:false
     */
    public static boolean hasText(String str){
        return !isEmpty(str) && containsText(str);
    }

    /**
     * 判断是否包含文本
     * @param str 字符串
     * @return 是否包含文本信息
     */
    private static boolean containsText(CharSequence str) {
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
