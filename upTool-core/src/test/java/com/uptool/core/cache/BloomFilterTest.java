package com.uptool.core.cache;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * TODO(这里用一句话描述这个类的作用)
 *
 * @author chenfuyuan
 * @date 2022/2/9 17:24
 */
public class BloomFilterTest extends TestCase {


    @Test
    public void testContain() {
        String value1 = "https://www.baidu.com/";
        String value2 = "https://github.com/chenfuyuan";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

    }

}