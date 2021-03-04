package com.uptool.core.util;



/**
 * @Description: 数字类型工具类
 * @Author Vito.Chen
 * @Date 2021/2/12 11:16
 */
public class NumberUtil {

    /**
     * 零
     */
    public static int ZERO = 0;

    /**
     * 一
     */
    public static int ONE = 1;

    /**
     * 双精度浮点数的零
     */
    public static double DOUBLE_ZERO = 0.0d;


    /**
     * 比较小于
     */
    public static final int COMPARE_LESS = -1;
    /**
     * 比较大于
     */
    public static final int COMPARE_MORE = 1;
    /**
     * 等于
     */
    public static final int COMPARE_EQUAL = 0;

    /*=======================isZero()======================*/
    /**
     * 判断整型数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(int value) {
        return value == 0;
    }

    /**
     * 判断双精度浮点数数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(double value) {
        return value < 1.0E-8D && value > -1.0E-8D;
    }

    /**
     * 判断单精度浮点数数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(float value) {
        return value < 1.0E-8 && value > -1.0E-8;
    }

    /**
     * 判断数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(short value) {
        return value == 0;
    }

    /**
     * 判断整型数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(long value) {
        return value == 0;
    }


    /**
     * 判断包装类型Double 是否为0 或为空
     * @param value 值
     * @return 判断结果  0或空 true, 否则为false
     */
    public static boolean isEmptyOrZero(Double value) {
        return value == null || isZero(value);
    }

    /**
     * 判断包装类型 Integer 是否为0 或为空
     * @param value 值
     * @return 判断结果  0或空 true, 否则为false
     */
    public static boolean isEmptyOrZero(Integer value) {
        return value == null || isZero(value);
    }



}
