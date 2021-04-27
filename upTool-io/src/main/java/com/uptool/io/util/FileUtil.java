package com.uptool.io.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;


/**
 * @Description: 文件工具类
 * @Author: chenfuyuan
 * @Date: 2021/4/27 21:42
 */
public class FileUtil {

    /**
     * 常量
     */
    public static class Constant{

        /**
         * 默认的文本单词分隔符
         */
        public static final String DEFAULT_FILE_WORD_SPLIT = " ";
    }


    /**
     * 获取文件
     * @param filePath 文件路径
     * @return 文件路径
     */
    public static File getFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    /**
     * 从文件中获取单词，默认以" "空格符分割单词
     * @param file 文件
     * @return 单词列表
     * @throws IOException IO异常
     */
    public static String[] getWordsByFile(File file) throws IOException {
        return getWordsByFile(file, Constant.DEFAULT_FILE_WORD_SPLIT);
    }
    /**
     * 从文件中获取单词
     * @param file 文件
     * @param splitFlag 分割标识
     * @return 单词列表
     * @throws IOException IO异常
     */
    public static String[] getWordsByFile(File file,String splitFlag) throws IOException {
        LinkedList<String> wordList = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitStrList = line.split(splitFlag);
                for (String s : splitStrList) {
                    wordList.addLast(s);
                }
            }
        }

        return wordList.toArray(new String[0]);
    }


    /**
     * 从文件中获取字符串
     * @param file 文件
     * @return 字符串数组
     */
    public static String[] getStringByFile(File file) throws IOException {
        List<String> stringList = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        try (
                FileInputStream in = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {

            String line;
            //读取行
            while ((line = bufferedReader.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    //处理转义字符
                    switch (ch) {
                        case '\\':
                            //转义字符
                            if (i + 1 < chars.length) {
                                break;
                            }
                            ch = chars[++i];
                            stringBuilder.append(ch);
                            break;

                        case '\"':
                        case '\'':
                            //引号
                            if (flag) {
                                //第二次处理引号
                                if (!"".equals(stringBuilder.toString().trim())) {
                                    stringList.add(stringBuilder.toString());
                                }
                                flag = false;
                                stringBuilder.setLength(0);
                            } else {
                                flag = true;
                            }
                            break;
                        case ' ':
                            //空格
                            if (flag) {
                                stringBuilder.append(ch);
                                break;
                            }
                            if (!"".equals(stringBuilder.toString().trim())) {
                                stringList.add(stringBuilder.toString());
                            }
                            flag = false;
                            stringBuilder.setLength(0);
                            break;
                        default:
                            //其他字符
                            stringBuilder.append(ch);
                    }

                }
                stringList.add(stringBuilder.toString().trim());
                stringBuilder.setLength(0);
                flag = false;
            }

        }

        return stringList.toArray(new String[0]);
    }


}
