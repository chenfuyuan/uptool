package com.uptool.core.util;

/**
 * @Description: 数组工具类
 * @Author chenfuyuan
 * @Date 2021/3/20 14:48
 */
public class ArrayUtil {

    /**
     * 初始索引
     */
    public static final int START_INDEX = 0;


    /**
     * 数组扩容
     * @param array 扩容数组
     * @param newLength 新长度
     * @param <T> 类型
     * @return 扩容后数组
     */
    public static <T> T[] resize(T[] array, int newLength) {
        T[] result = (T[]) new Object[newLength];
        int min = array.length > newLength ? newLength : array.length;
        System.arraycopy(array,START_INDEX,result,START_INDEX,min);
        return result;
    }
}
