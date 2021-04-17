package com.uptool.core.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: 数组工具类测试
 * @Author: chenfuyuan
 * @Date: 2021/4/17 16:03
 */
public class ArrayUtilTest {

    @Test
    public void testOffset() {
        Integer[] array = {1,2,3,4,5};
        ArrayUtil.offset(array,2,-1);
        System.out.println(Arrays.toString(array));
    }
}
