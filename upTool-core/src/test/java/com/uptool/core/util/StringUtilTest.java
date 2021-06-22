package com.uptool.core.util;

import org.junit.Test;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/6/23 1:27
 */
public class StringUtilTest {

    @Test
    public void testRemoveSurplusSpace() {
        String str = "  1  abc  def";
        System.out.println(str);
        String outcome = StringUtil.removeSurPlusSpace(str);
        System.out.println(outcome);
    }
}
