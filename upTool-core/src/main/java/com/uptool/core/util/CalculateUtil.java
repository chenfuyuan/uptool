package com.uptool.core.util;

import static com.uptool.core.util.NumberUtil.toBigDecimal;

/**
 * @Description: 计算工具类
 * @Author chenfuyuan
 * @Date 2021/3/18 18:58
 */
public class CalculateUtil {

    private static int DIVIDE_RETAIN_SCALE_DEFAULT = 2;
    /**
     * 值1加值2
     * @param v1 值1
     * @param v2 值2
     * @return 加操作结果
     */
    public static double add(double v1, double v2) {
        return toBigDecimal(v1).add(toBigDecimal(v2)).doubleValue();
    }

    /**
     * 值1加值2
     * @param v1 值1
     * @param v2 值2
     * @return 加操作结果
     */
    public static double add(double v1, int v2) {
        return toBigDecimal(v1).add(toBigDecimal(v2)).doubleValue();
    }

    /**
     * 值1加值2
     * @param v1 值1
     * @param v2 值2
     * @return 加操作结果
     */
    public static double add(int v1, double v2) {
        return toBigDecimal(v1).add(toBigDecimal(v2)).doubleValue();
    }

    /**
     * 值1加值2
     * @param v1 值1
     * @param v2 值2
     * @return 加操作结果
     */
    public static int add(int v1, int v2) {
        return toBigDecimal(v1).add(toBigDecimal(v2)).intValue();
    }

    /**
     * 值1除以值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static double divide(double v1,double v2) {
        return toBigDecimal(v1).divide(toBigDecimal(v2),DIVIDE_RETAIN_SCALE_DEFAULT).doubleValue();
    }


    /**
     * 值1除以值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static double divide(double v1,int v2) {
        return toBigDecimal(v1).divide(toBigDecimal(v2),DIVIDE_RETAIN_SCALE_DEFAULT).doubleValue();
    }

    /**
     * 值1除以值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static double divide(int v1,double v2) {
        return toBigDecimal(v1).divide(toBigDecimal(v2),DIVIDE_RETAIN_SCALE_DEFAULT).doubleValue();
    }

    /**
     * 值1除以值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static int divide(int v1,int v2) {
        return toBigDecimal(v1).divide(toBigDecimal(v2),DIVIDE_RETAIN_SCALE_DEFAULT).intValue();
    }

    /**
     * 值1减去值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static double subtract(double v1, double v2) {
        return toBigDecimal(v1).subtract(toBigDecimal(v2)).doubleValue();
    }


    /**
     * 值1减去值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static double subtract(double v1, int v2) {
        return toBigDecimal(v1).subtract(toBigDecimal(v2)).doubleValue();
    }

    /**
     * 值1减去值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static double subtract(int v1, double v2) {
        return toBigDecimal(v1).subtract(toBigDecimal(v2)).doubleValue();
    }

    /**
     * 值1减去值2
     * @param v1 值1
     * @param v2 值2
     * @return 操作结果
     */
    public static int subtract(int v1, int v2) {
        return toBigDecimal(v1).subtract(toBigDecimal(v2)).intValue();
    }



}
