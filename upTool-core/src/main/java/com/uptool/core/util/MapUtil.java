package com.uptool.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: Map工具类
 * @Author Vito.Chen
 * @Date 2021/3/4 13:24
 */
public class MapUtil {


    /**
     * 加载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认容量
     */
    public static final int DEFAULT_CAPACITY  = 16;

    /**
     * 计算初始化HashMap 比较恰当的容量
     * @param size 长度
     * @return 恰当的容量
     */
    public static int caluateBestCapacity(int size) {
        return (int) (size / DEFAULT_LOAD_FACTOR + 1);
    }


    /**
     * 计算初始化HashMap 比较恰当的容量
     * @param size 长度
     * @return 恰当的容量
     */
    public static int caluateBestCapacity(int size, Double loadFactor) {
        if (NumberUtil.isEmptyOrZero(loadFactor) || loadFactor.compareTo(NumberUtil.DOUBLE_ZERO) == NumberUtil.COMPARE_LESS) {
            throw new IllegalArgumentException("计算初始化HashMap较优容量错误:加载因子小于等于0");
        }

        return (int) (size / loadFactor + 1);
    }


    /**
     * map是否包含key
     * @param map 映射
     * @param key 关键字
     * @return key是否包含在map中
     */
    public static boolean contain(Map<?,?> map, String key) {
        if (map == null) {
            throw new RuntimeException("校验key是否在map中时报错:map为空");
        }

        if (map.size() == 0) {
            return false;
        }

        return map.containsKey(key);
    }

    /**
     * 从map中获取值
     * @param map 数据源
     * @param key 关键字
     * @param <A> 关键字类型
     * @param <B> 数据类型
     * @return 值
     */
    public static <A, B> B getValue(Map<A, B> map, String key) {
        if (map == null) {
            throw new RuntimeException("从map中获取数据报错:map为空");
        }

        return map.get(key);
    }

    /**
     * 填充数据到map中
     * @param map 数据源
     * @param key 关键字
     * @param value 数据
     * @param <A> 关键字数据类型
     * @param <B> 数据 数据类型
     */
    public static <A, B> void put(Map<A, B> map, A key, B value) {
        if (map == null) {
            throw new RuntimeException("向map中填充数据时:map为空");
        }

        map.put(key, value);
    }

    /**
     * 填充数据到map中，map的value 为集合对象
     * @param map map
     * @param key 关键字
     * @param valueItem 值
     * @param <A> 泛型 key的泛型
     * @param <B> 泛型 value的泛型
     */
    public static<A,B> void putToSet(Map<A, Set<B>> map, A key, B valueItem) {
        if (map == null) {
            throw new RuntimeException("向map中填充数据时:map为空");
        }

        Set<B> mapItem = map.get(key);
        if (mapItem == null) {
            mapItem = new HashSet<>();
            map.put(key, mapItem);
        }

        mapItem.add(valueItem);
    }

    /**
     * 填充数据到map中，map的value 为集合对象
     * @param map map
     * @param key 关键字
     * @param valueItem 值
     * @param <A> 泛型 key的泛型
     * @param <B> 泛型 value的泛型
     */
    public static<A,B> void putToList(Map<A, List<B>> map, A key, B valueItem) {
        if (map == null) {
            throw new RuntimeException("向map中填充数据时:map为空");
        }

        List<B> mapItem = map.get(key);
        if (mapItem == null) {
            mapItem = new ArrayList<>();
            map.put(key, mapItem);
        }

        mapItem.add(valueItem);
    }

    public static <T,F> Map<T,F> getNullMap() {
        return new HashMap<>(0);
    }

    /**
     * 转换List To Map
     * 值存放自身
     * 冲突规则 拿新数据覆盖旧数据
     * @param collection 集合
     * @param keyMapper key函数
     * @param <K> key
     * @param <V> value
     * @return 转换结果 Map<key,自身对象>
     */
    public static <K,V> Map<K,V> convertCollectionToMap(Collection<V> collection, Function<V, ? extends K> keyMapper) {
        return collection.stream().collect(Collectors.toMap(keyMapper, Function.identity(),(oldData,newData)->newData));
    }


    /**
     * 转换List To Map
     * 值存放自身
     * @param collection 集合
     * @param keyMapper key函数
     * @param mergeFunction 解决冲突函数
     * @param <K> key
     * @param <V> value
     * @return 转换结果 Map<key,自身对象>
     */
    public static <K,V> Map<K,V> convertCollectionToMap(Collection<V> collection, Function<V, ? extends K> keyMapper, BinaryOperator<V> mergeFunction) {
        return collection.stream().collect(Collectors.toMap(keyMapper, Function.identity(),mergeFunction));
    }

    /**
     * 转换List To Map
     * 值存放 该对象集合
     * 冲突规则 key相同时，存放在同一个List中
     * @param collection 集合
     * @param keyMapper key函数
     * @param <K> key
     * @param <V> value
     * @return 转换结果 Map<key,对象列表>
     */
    public static <K,V> Map<K, List<V>> convertCollectionToMapList(Collection<V> collection, Function<V,? extends K> keyMapper) {
        return collection.stream().collect(Collectors.toMap(keyMapper, item -> {
            List<V> result = new ArrayList<>();
            result.add(item);
            return result;
        }, (List<V> oldData, List<V> newData) -> {
            oldData.addAll(newData);
            return oldData;
        }));
    }
}
