package com.uptool.core.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Set工具类
 * @Author Vito.Chen
 * @Date 2021/3/4 14:45
 */
public class SetUtil extends HashDataStructUtil {


    public static final int DEFAULT_HASH_CAPACITY = 16;

    /**
     * 当value非空时，填充数倒集合中
     * @param set 集合
     * @param values 值数组
     */
    public static void fillValueToSet(Set<String> set, String... values) {
        if (EmptyUtil.isEmpty(values)) {
            return;
        }

        if (set == null) {
            return;
        }

        for (String value : values) {
            if (EmptyUtil.isNotEmpty(value)) {
                set.add(value);
            }
        }
    }

    /**
     * set是否包含key
     * @param set 映射
     * @param key 关键字
     * @return key是否包含在map中
     */
    public static boolean contain(Set<?> set, String key) {
        if (set == null) {
            throw new RuntimeException("校验key是否在map中时报错:map为空");
        }

        if (set.size() == 0) {
            return false;
        }

        return set.contains(key);
    }

    /**
     * 合并集合
     * @param setList 集合列表
     * @param <T> 集合类型
     * @return 合并结果 新集合
     */
    @SafeVarargs
    public static <T> Set<T> union(Set<T>... setList) {
        if (setList == null) {
            return new HashSet<>(DEFAULT_HASH_CAPACITY);
        }

        int size = 0;

        for (Set<T> set : setList) {
            if (set!=null) {
                size += set.size();
            }
        }

        Set<T> result = new HashSet<>(caluateBestCapacity(size));
        for (Set<T> set : setList) {
            if (EmptyUtil.isNotEmpty(set)) {
                result.addAll(set);
            }
        }

        return result;
    }

}
