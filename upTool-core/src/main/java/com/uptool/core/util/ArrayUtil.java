package com.uptool.core.util;

import com.uptool.core.Exception.ArgumentEmptyException;
import com.uptool.core.Exception.MatchNoSuchClassException;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.uptool.core.util.EmptyUtil.isEmpty;

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
     * 整型数组空值
     */
    public static final int INT_EMPTY_VALUE = -1;

    /**
     * 缩小系数(个数) 数组个数<数组长度*缩小系数(个数)时进行缩小数组
     */
    public static final double SHRINK_SIZE_FACTOR = 0.25;

    /**
     * 数组扩容
     *
     * @param array     扩容数组
     * @param newLength 新长度
     * @param <T>       类型
     * @return 扩容后数组
     */
    public static <T> T[] resize(T[] array, int newLength) {
        if (newLength == 0) {
            throw new RuntimeException("扩容容量为0");
        }
        Class<?> classType = null;

        for (T t : array) {
            if (t != null) {
                classType = t.getClass();
                break;
            }
        }

        if (classType == null) {
            throw new MatchNoSuchClassException();
        }

        T[] result = (T[]) Array.newInstance(classType, newLength);
        int min = Math.min(array.length, newLength);
        System.arraycopy(array, START_INDEX, result, START_INDEX, min);
        return result;
    }


    /**
     * 数组扩容
     *
     * @param array     扩容数组
     * @param newLength 新长度
     * @return 扩容后数组
     */
    public static int[] resize(int[] array, int newLength) {
        if (newLength == 0) {
            throw new RuntimeException("扩容容量为0");
        }
        int[] result = new int[newLength];
        int min = Math.min(array.length, newLength);
        System.arraycopy(array, START_INDEX, result, START_INDEX, min);
        return result;
    }

    /**
     * 数组扩容
     *
     * @param array     扩容数组
     * @param newLength 新长度
     * @param <T>       类型
     * @return 扩容后数组
     */
    public static <T> T[] resize(T[] array, int newLength, Class<?> classType) {
        if (newLength == 0) {
            throw new RuntimeException("扩容容量为0");
        }
        T[] result = (T[]) Array.newInstance(classType, newLength);
        int min = Math.min(array.length, newLength);
        System.arraycopy(array, START_INDEX, result, START_INDEX, min);
        return result;
    }


    /**
     * 拷贝数组
     *
     * @param source 源
     * @param target 目标
     * @param <T> 数组类型
     */
    public static <T> void copy(T[] source, T[] target) {
        int minLength = Math.min(source.length, target.length);
        copy(source, target, START_INDEX, minLength);
    }

    /**
     * 拷贝数组
     *
     * @param source     源
     * @param target     目标
     * @param startIndex 开始索引
     * @param length     长度
     * @param <T> 数组类型
     */
    public static <T> void copy(T[] source, T[] target, int startIndex, int length) {
        copy(source, target, startIndex, length, startIndex);
    }

    public static <T> void copy(T[] source, T[] target, int sourceStartIndex, int length, int targetStartIndex) {
        System.arraycopy(source, sourceStartIndex, target, targetStartIndex, length);
    }

    /**
     * 克隆数组
     *
     * @param source 数据源
     * @param <T>    数据类型
     * @return 克隆后的数组
     */
    public static <T> T[] cloneArray(T[] source) {
        return cloneArray(source, START_INDEX, source.length);
    }

    /**
     * 克隆数组
     *
     * @param source     数据源
     * @param startIndex 开始位置
     * @param length     克隆长度
     * @param <T>        数据类型
     * @return 克隆后的数组
     */
    public static <T> T[] cloneArray(T[] source, int startIndex, int length) {
        T[] result = (T[]) new Object[length];
        copy(source, result, startIndex, length, START_INDEX);
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

    /**
     * 获取一个索引数组
     *
     * @param startIndex 开始索引
     * @param length     长度
     * @return 索引数组
     */
    public static int[] getIndexArray(int startIndex, int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = startIndex + i;
        }
        return result;
    }

    /**
     * 新建一个数组
     *
     * @param size      数组大小
     * @param classType 数组类型
     * @param <T>       泛型
     * @return 新建的数组
     */
    public static <T> T[] newArray(int size, Class<T> classType) {
        return (T[]) Array.newInstance(classType, size);
    }

    /**
     * 初始化数组
     *
     * @param array        数组
     * @param defaultValue 默认值
     * @param <T>          数组类型
     */
    public static <T> void initArray(T[] array, T defaultValue) {
        if (isEmpty(array)) {
            throw new ArgumentEmptyException("传递进来的数组对象为空;");
        }

        Arrays.fill(array, defaultValue);
    }

    /**
     * 初始化数组
     *
     * @param array        数组
     * @param defaultValue 默认值
     * @param startIndex   开始索引
     * @param length       操作长度
     * @param <T>          数组类型
     */
    public static <T> void initArray(T[] array, T defaultValue, int startIndex, int length) {
        if (isEmpty(array)) {
            throw new ArgumentEmptyException("传递进来的数组对象为空;");
        }

        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);

        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = defaultValue;
        }
    }

    /**
     * 初始化整型数组
     *
     * @param array        数组
     * @param defaultValue 默认值
     */
    public static void initArray(int[] array, int defaultValue) {
        if (isEmpty(array)) {
            throw new ArgumentEmptyException("传递进来的数组对象为空;");
        }

        Arrays.fill(array, defaultValue);
    }

    /**
     * 初始化整型数组
     *
     * @param array        数组
     * @param defaultValue 默认值
     * @param startIndex   开始索引
     * @param length       操作长度
     */
    public static void initArray(int[] array, int defaultValue, int startIndex, int length) {
        if (isEmpty(array)) {
            throw new ArgumentEmptyException("传递进来的数组对象为空;");
        }
        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);
        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = defaultValue;
        }
    }

    /**
     * 将数组索引位置开始进行偏移
     * @param array 数组
     * @param index 索引
     * @param offset 偏移量
     * @param <T> 数组类型
     */
    public static<T> void offset(T[] array, int index, int offset) {
        offset(array,index,offset,array.length-1);
    }

    /**
     * 将数组索引位置开始进行偏移
     * @param array 数组
     * @param startIndex 索引
     * @param offset 偏移量
     * @param endIndex 结束索引
     * @param <T> 数组类型
     */
    public static<T> void offset(T[] array, int startIndex, int offset,int endIndex) {
        if (offset == 0 || array.length - Math.abs(offset) <= 0) {
            return;
        }

        if (offset > 0) {
            //元素后移,直接覆盖后方元素
            offsetBack(array,startIndex,offset,endIndex);
        }else{
            //元素前移，直接覆盖前面元素
            offsetPre(array,startIndex,-offset,endIndex);
        }
    }


    /**
     * 向前偏移
     * @param array 数组
     * @param startIndex 偏移开始索引
     * @param offset 偏移量
     * @param endIndex 偏移结束索引
     * @param <T> 数组类型
     */
    private static<T> void offsetPre(T[] array, int startIndex, int offset,int endIndex) {
        for (int i = startIndex-offset, endFlag = endIndex - offset; i <= endFlag; i++) {
            array[i] = array[i + offset];
        }
    }

    /**
     * 向后偏移
     * @param array 数组
     * @param startIndex 偏移开始索引
     * @param offset 偏移量
     * @param endIndex 偏移结束索引
     * @param <T> 数组类型
     */
    private static<T> void offsetBack(T[] array, int startIndex, int offset,int endIndex) {
        for (int i = endIndex+offset, endFlag = startIndex + offset; i >= endFlag; i--) {
            array[i] = array[i - offset];
        }
    }

    /**
     * 交换数组元素
     * 将array[i] 和 array[j]互换
     * @param array 数组
     * @param i 索引i
     * @param j 索引j
     * @param <T> 数组类型
     */
    public static <T> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
