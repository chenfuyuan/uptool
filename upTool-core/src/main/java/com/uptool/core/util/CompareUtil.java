package com.uptool.core.util;

/**
 * @Description: 比较工具类
 * @Author: chenfuyuan
 * @Date: 2021/4/10 17:00
 */
public class CompareUtil {

    /**
     * 比较值相等-0
     */
    public static final int COMPARETO_EQUAL = 0;

    /**
     * 两则进行比较，判断obj1是否小于obj2
     * @param obj1 比较对象
     * @param obj2 比较对象
     * @return true:小于
     */
    public static boolean less(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) < COMPARETO_EQUAL;
    }

    /**
     * 两则进行比较，判断obj1是否等于obj2
     * @param obj1 比较对象
     * @param obj2 比较对象
     * @return true:等于
     */
    public static boolean equal(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) == COMPARETO_EQUAL;
    }

    /**
     * 两则进行比较，判断obj1是否大于obj2
     * @param obj1 比较对象
     * @param obj2 比较对象
     * @return true:大于
     */
    public static boolean more(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) > COMPARETO_EQUAL;
    }

}
