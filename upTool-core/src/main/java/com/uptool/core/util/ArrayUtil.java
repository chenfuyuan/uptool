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
     * @param startIndex 开始索引
     * @param length 长度
     * @param <T>
     */
    public static <T> void copy(T[] source, T[] target, int startIndex, int length) {
        /*int endIndex = SortUtil.getEndIndex(startIndex, source.length, length);

        while (startIndex <= length) {
            target[startIndex] = source[startIndex];
            startIndex++;
        }*/
        copy(source,target,startIndex,length,startIndex);
    }

    public static <T> void copy(T[] source, T[] target, int sourceStartIndex, int length, int targetStartIndex) {
        System.arraycopy(source,sourceStartIndex,target,targetStartIndex,length);
    }

    /**
     * 克隆数组
     * @param source 数据源
     * @param <T> 数据类型
     * @return 克隆后的数组
     */
    public static <T> T[] cloneArray(T[] source) {
        return cloneArray(source, START_INDEX, source.length);
    }

    /**
     * 克隆数组
     * @param source 数据源
     * @param startIndex 开始位置
     * @param length 克隆长度
     * @param <T> 数据类型
     * @return 克隆后的数组
     */
    public static <T> T[] cloneArray(T[] source, int startIndex, int length) {
        T[] result = (T[]) new Object[length];
        copy(source,result,startIndex,length,START_INDEX);
        return result;
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
