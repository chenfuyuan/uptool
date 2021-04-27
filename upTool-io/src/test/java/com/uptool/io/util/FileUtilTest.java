package com.uptool.io.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Description: 测试文件工具类
 * @Author: chenfuyuan
 * @Date: 2021/4/27 22:49
 */
public class FileUtilTest{

    @Test
    public void testReadString() throws IOException {
        File file = FileUtil.getFile("learnPlan.txt");
        String[] stringByFile = FileUtil.getStringByFile(file);
        System.out.println(Arrays.toString(stringByFile));
    }

}