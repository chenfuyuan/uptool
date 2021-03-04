package com.uptool.core.util;

/**
 * @Description: 散列数据结构父类
 * @Author Vito.Chen
 * @Date 2021/3/4 14:52
 */
public abstract class HashDataStructUtil {

    /**
     * 加载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认容量
     */
    public static final int DEFAULT_CAPACITY  = 16;

    /**
     * 计算初始化HashMap 比较恰当的容量
     * @param size 长度
     * @return 恰当的容量
     */
    public static int caluateBestCapacity(int size) {
        return (int) (size / DEFAULT_LOAD_FACTOR + 1);
    }


    /**
     * 计算初始化HashMap 比较恰当的容量
     * @param size 长度
     * @return 恰当的容量
     */
    public static int caluateBestCapacity(int size, Double loadFactor) {
        if (NumberUtil.isEmptyOrZero(loadFactor) || loadFactor.compareTo(NumberUtil.DOUBLE_ZERO) == NumberUtil.COMPARE_LESS) {
            throw new IllegalArgumentException("计算初始化HashMap较优容量错误:加载因子小于等于0");
        }
        return (int) (size / loadFactor + 1);
    }


}
