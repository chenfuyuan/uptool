package com.uptool.core.util;

import com.uptool.core.stdlib.StdRandom;

import java.util.Random;

/**
 * @Description: 生成随机数据工具类
 * @Author: chenfuyuan
 * @Date: 2021/3/25 15:36
 */
public class RandomUtil {

    private static final String[] LETTER_LIST={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private static Random random = new Random();

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

    /**
     * 生成一个 大写字母的随机数组
     * @param size 大小
     * @return 随机生成的String数组
     */
    public static String[] generateCapitalLetterArray(int size) {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomCapitalLetter();
        }
        return result;
    }

    /**
     * 随机生成字母
     * 65-90 ascii 字母编码范围
     * @return 随机生成的字母
     */
    private static String randomCapitalLetter() {
        return LETTER_LIST[random.nextInt(LETTER_LIST.length)];
    }

}
