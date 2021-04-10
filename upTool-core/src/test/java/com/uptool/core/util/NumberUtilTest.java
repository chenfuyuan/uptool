package com.uptool.core.util;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: chenfuyuan
 * @Date: 2021/4/10 16:41
 */
public class NumberUtilTest extends TestCase {

    /**
     * 测试是否为2的倍数
     */
    @Test
    public void testIsTwoMultiples() {
        for (int i = 0; i <= 16; i++) {
            System.out.printf("%d是2的倍数吗？%s\n",i,NumberUtil.isTwoMultiples(i)?"是":"否");
        }
    }

    @Test
    public void testCaculateTwoMultiples() {
        for (int i = 0; i <= 16; i++) {
            System.out.printf("%d是2的倍数吗？%s。几倍? %d\n",i,NumberUtil.isTwoMultiples(i)?"是":"否",NumberUtil.calculateTwoMultiples(i));
        }
    }
}