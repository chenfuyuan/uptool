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

    /**
     * 拷贝数组
     * @param source 源
     * @param target 目标
     * @param <T>
     */
    public static <T> void copy(T[] source,T[] target) {
        int minLength = Math.min(source.length, target.length);
        copy(source,target,START_INDEX,minLength);
    }

    /**
     * 拷贝数组
     * @param source 源
     * @param target 目标
     * @param low 低索引
     * @param hight 高索引
     * @param <T>
     */
    public static <T> void copy(T[] source, T[] target, int low, int hight) {
        if (low > hight) {
            low = low ^ hight;
            hight = low ^ hight;
            low = low ^ hight;
        }

        if (source.length < hight || target.length < hight) {
            throw new IndexOutOfBoundsException("索引位置错误，超过数组索引范围;");
        }
        while (low <= hight) {
            target[low] = source[low];
            low++;
        }
    }

    public static <T> boolean equals(T[] array1, T[] array2, int low, int hight) {
        while (low <= hight) {
            if (!array1[low].equals(array2[low])) {
                return false;
            }
            low++;
        }
        return true;
    }
}
