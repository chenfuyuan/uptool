package com.uptool.io.util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 控制台工具类
 * @Author: chenfuyuan
 * @Date: 2021/6/20 20:25
 */
public class TerminalUtil {


    private TerminalUtil(){}

    /**
     * 控制台输入单例
     */
    private static Scanner TERMINAL_INPUT_INSTANCE;


    private static final String DEFAULT_SPLIT = ",";

    /**
     * 获取控制台输入
     * @return 控制台输入
     */
    public static Scanner getTerminalInput() {
        if (TERMINAL_INPUT_INSTANCE == null) {

            synchronized (TerminalUtil.class) {

                if (TERMINAL_INPUT_INSTANCE == null) {
                    TERMINAL_INPUT_INSTANCE = new Scanner(System.in);
                    return TERMINAL_INPUT_INSTANCE;
                }
            }
        }

        return TERMINAL_INPUT_INSTANCE;
    }

    public static boolean isTrue(String str) {
        return "Y".equals(str.toUpperCase()) || "YES".equals(str.toUpperCase());
    }

    public static int[] strToInt(String split, String source) {
        String[] splitArray = source.split(split);
        return Arrays.stream(splitArray).mapToInt(item -> Integer.parseInt(item)).toArray();
    }

    public static int[] strToInt(String source) {
        return strToInt(DEFAULT_SPLIT, source);

    }
}
