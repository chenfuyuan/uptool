package com.uptool.core.util;


import java.math.BigDecimal;
import java.math.RoundingMode;

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

    /**
     * 默认保留两位小数
     */
    public static final int DEFAULT_SCALE = 2;

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


    /**
     * 拆箱，避免为空
     * @param value 值
     * @return 双精度浮点数据类型
     */
    public static double valueOf(Double value) {
        return isEmptyOrZero(value) ? DOUBLE_ZERO : value;
    }

    /**
     * 拆箱，避免为空
     * @param value 值
     * @return 整型基础数据类型
     */
    public static int valueOf(Integer value) {
        return isEmptyOrZero(value) ? ZERO : value;
    }

    /**
     * Double转换成BigDecimal类型
     * @param value 值
     * @return 对应BigDecimal对象
     */
    public static BigDecimal toBigDecimal(double value) {
       return BigDecimal.valueOf(valueOf(value)).setScale(DEFAULT_SCALE,RoundingMode.HALF_UP);
    }


    /**
     * Integer转换成BigDecimal类型
     * @param value 值
     * @return 对应BigDecimal对象
     */
    public static BigDecimal toBigDecimal(int value) {
        return BigDecimal.valueOf(valueOf(value));
    }

    /**
     * 保留小数个数
     * @param value 值
     * @param scale 小数位数
     * @return
     */
    public static double fixScale(double value,int scale) {
        return BigDecimal.valueOf(valueOf(value)).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 默认保留 DEFAULT_SCALE位 小数
     * @param value 值
     * @return
     */
    public static double fixScale(double value) {
        return fixScale(value, DEFAULT_SCALE);
    }


}
