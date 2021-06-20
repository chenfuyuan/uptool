package com.uptool.io.util;

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
}
