package com.uptool.core.util;

import com.uptool.core.stdlib.StdRandom;

/**
 * @Description: 生成随机数据工具类
 * @Author: chenfuyuan
 * @Date: 2021/3/25 15:36
 */
public class RandomUtil {

    /**
     * 生成一个随机的Double类型数组
     * @author chenfuyuan
     * @date 2021/3/25 15:42
     * @param size 大小
     * @return java.lang.Double[] 随机生成的Double类型数组
     */
    public static Double[] generateDoubleArray(int size) {
        Double[] result = new Double[size];
        for (int i = 0; i < size; i++) {
            result[i] = StdRandom.uniform();
        }
        return result;
    }
}
