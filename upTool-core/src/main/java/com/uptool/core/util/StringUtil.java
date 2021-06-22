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

    /**
     * 清除字符串中多余空格 当超过两个空格时，都缩减为一个空格
     * @param str 字符串
     * @return 去除结果
     */
    public  static String removeSurPlusSpace(String str) {
        char[] chars = str.toCharArray();
        //找到第一个不是空格的位置
        int startIndex = 0;
        while (startIndex < chars.length && ' ' == chars[startIndex]) {
            startIndex++;
        }

        //上一个字符串是否为空格
        boolean preCharIsSpace = false;
        //是否对数组进行偏移
        boolean isMove = false;
        //偏移量
        int offset = 0;

        for (int i = startIndex+1; i < chars.length-offset; i++) {
            //i+offset为偏移后的位置
            if (' ' == chars[i+offset]) {
                if (preCharIsSpace) {
                    //当第二次空格时，将后面的元素偏移量+1
                    offset++;
                    isMove = true;
                } else {
                    preCharIsSpace = true;
                }
            }else {
                preCharIsSpace = false;
            }

            //偏移
            if (isMove){
                chars[i] = chars[i + offset];
            }

        }

        //生成新的字符串
        return new String(chars, startIndex, chars.length - startIndex - offset);
    }
}
