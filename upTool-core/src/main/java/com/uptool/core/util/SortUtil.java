package com.uptool.core.util;

/**
 * @Description: 排序工具类
 * @Author chenfuyuan
 * @Date 2021/3/24 14:36
 */
public class SortUtil {


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


    /**
     * 交换次序
     * @param a 交换数据源
     * @param i 交换索引1
     * @param j 交换索引2
     */
    public static void exch(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 使用位运算交换次序，提高效率
     * @param a 交换数据源
     * @param i 交换索引1
     * @param j 交换索引2
     */
    public static void exch(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    /**
     * 使用位运算交换次序，提高效率
     * @param a 交换数据源
     * @param i 交换索引1
     * @param j 交换索引2
     */
    public static void exch(long[] a, int i, int j) {
        if (i == j) {
            return;
        }
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }


    /**
     * 遍历展现数组
     * @param array 数组
     */
    public static void show(Comparable[] array) {

        //单行打印数组
        for (int i = 0,length = array.length; i < length; i++) {
            System.out.print(array[i] + "");
        }
        System.out.println();
    }

    /**
     * 遍历展现数组(从low到hight)
     * @param array 数组
     * @param low 低索引
     * @param hight 高索引
     */
    public static void show(Comparable[] array,int low,int hight) {

        //单行打印数组
        for (int i = low; i <= hight; i++) {
            System.out.print(array[i] + "");
        }
        System.out.println();
    }

    /**
     * 判断是否有序
     * @param array 数组
     * @return 是否有序
     */
    public static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否有序(从low到hight位置判断)
     * @param array 数组
     ** @param low 低索引
     ** @param hight 高索引
     * @return 是否有序
     */
    public static boolean isSorted(Comparable[] array,int low ,int hight) {
        if (low > hight) {
            throw new IndexOutOfBoundsException("低索引大于高索引");
        }
        if (low == hight) {
            return true;
        }
        for (int i = low+1; i <= hight; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
