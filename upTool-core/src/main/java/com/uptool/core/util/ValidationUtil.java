package com.uptool.core.util;

import com.uptool.core.Exception.ValidationException;


import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 校验工具类
 * @Author Chen.FuYuan
 * @Date 2021/3/4 10:50
 */
public class ValidationUtil {

    /**
     * 错误信息
     */
    private final StringBuilder errorMsg;

    /**
     * 默认大小
     */
    public static final int DEFAULT_STRING_CACHE_CAPACITY = 32;

    /**
     * 私有化构造函数
     */
    private ValidationUtil() {
        errorMsg = new StringBuilder(DEFAULT_STRING_CACHE_CAPACITY);
    }

    /**
     * 生成一个新对象
     * @return 对象
     */
    public static ValidationUtil newInstance() {
        return new ValidationUtil();
    }

    /**
     * 抛出错误信息
     * @param msg 错误信息
     */
    public static void throwErr(String msg) throws ValidationException {
        if (EmptyUtil.isNotEmpty(msg)) {
            throw new ValidationException(msg);
        }
    }

    /**
     * 校验是否为空
     * @param obj 校验对象
     * @param msg 校验错误输出信息
     * @return 自身
     */
    public ValidationUtil checkEmpty(Object obj, String msg) {
        if (EmptyUtil.isEmpty(obj)) {
            errorMsg.append(msg);
        }
        return this;
    }

    /**
     * 校验是否为空
     * @param obj 校验对象
     * @param msg 校验错误输出信息
     * @return 自身
     */
    public ValidationUtil checkEmpty(Map<?,?> obj, String msg) {
        if (EmptyUtil.isEmpty(obj)) {
            errorMsg.append(msg);
        }
        return this;
    }

    /**
     * 拼接错误信息
     * @param msg 信息
     * @return 自身
     */
    public ValidationUtil addError(String msg) {
        if (EmptyUtil.isNotEmpty(msg)) {
            errorMsg.append(msg);
        }
        return this;
    }

    /**
     * 校验非空
     * @param obj     校验对象
     * @param message 校验为空时，添加到错误信息中
     */
    public ValidationUtil checkEmpty(Collection<?> obj, String message) {
        if (EmptyUtil.isEmpty(obj)) {
            errorMsg.append(message);
        }
        return this;
    }

    /**
     * 校验非空
     * @param obj     校验对象
     * @param message 校验为空时，添加到错误信息中
     */
    public ValidationUtil checkEmpty(String obj, String message) {
        if (EmptyUtil.isEmpty(obj)) {
            errorMsg.append(message);
        }
        return this;
    }

    /**
     * 校验 map中是否包含对应的key
     * @param sourceMap 校验数据源map
     * @param key 关键字
     * @param msg 校验提示信息
     * @return 自身
     */
    public <K,V> ValidationUtil checkNotContainInMap(Map<K,V> sourceMap, K key, String msg) {
        if (sourceMap == null) {
            throw new RuntimeException("校验数据源为空");
        }

        if (!sourceMap.containsKey(key)) {
            errorMsg.append(msg);
        }

        return this;
    }

    /**
     * 校验 map中是否包含对应的key
     * @param sourceMap 校验数据源map
     * @param key 关键字
     * @param msg 校验提示信息
     * @return 自身
     */
    public <K,V> ValidationUtil checkContainInMap(Map<K,V> sourceMap, K key, String msg) {
        if (sourceMap == null) {
            throw new RuntimeException("校验数据源为空");
        }

        if (sourceMap.containsKey(key)) {
            errorMsg.append(msg);
        }

        return this;
    }

    /**
     * 校验 map中是否包含对应的key
     * @param set 校验数据源set
     * @param key 关键字
     * @param msg 校验提示信息
     * @return 自身
     */
    public ValidationUtil checkContainInSet(Set<String> set, String key, String msg) {
        if (EmptyUtil.isEmpty(set)) {
            throw new RuntimeException("校验数据源为空");
        }

        if (set.contains(key)) {
            errorMsg.append(msg);
        }

        return this;
    }


    /**
     * 如果有错误则抛出异常
     * @throws ValidationException 异常
     * @return 自身
     */
    public ValidationUtil throwError() throws ValidationException {
        if (isFail()) {
            throw new ValidationException(getErrorMsg());
        }
        return this;
    }

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    public String getErrorMsg() {
        return errorMsg.toString();
    }


    /**
     * 校验是否失败
     *
     * @return 失败 true : 成功 false
     */
    public boolean isFail() {
        return errorMsg.length() > 0 && !StringUtil.STRING_NULL.equals(errorMsg.toString()) && !StringUtil.STRING_EMPTY.equals(errorMsg.toString());
    }

    /**
     * 校验是否成功
     *
     * @return 成功 true : 失败 false
     */
    public boolean isSuccess() {
        return !isFail();
    }


    /**
     * 清空错误信息缓存
     */
    public void cleanErrorMsg() {
        errorMsg.delete(0, errorMsg.length());
    }

    /**
     * 校验其中之一是否为空，为空则填充错误信息
     * @param obj1 校验对象1
     * @param obj2 校验对象2
     * @param msg 错误信息
     */
    public ValidationUtil checkOneEmpty(String obj1, String obj2, String msg) {
        if (EmptyUtil.isEmpty(obj1) || EmptyUtil.isEmpty(obj2)) {
            errorMsg.append(msg);
        }

        return this;
    }

    /**
     * 校验其中之一是否都为空，都为空则填充错误信息
     * @param obj1 校验对象1
     * @param obj2 校验对象2
     * @param msg 错误信息
     */
    public ValidationUtil checkAllEmpty(String obj1, String obj2, String msg) {
        if (EmptyUtil.isEmpty(obj1) && EmptyUtil.isEmpty(obj2)) {
            errorMsg.append(msg);
        }

        return this;
    }

    /**
     * 如果错误 抛出运行时异常
     */
    public ValidationUtil throwRunTimeException() {
        if (isFail()) {
            throw new RuntimeException(errorMsg.toString());
        }
        return this;
    }

    /**
     * 判断是否小于0
     * @param value 值
     * @param msg 错误信息
     * @return 自身引用
     */
    public ValidationUtil checkLessZero(Integer value,String msg) {
        int source = 0;
        if (value != null) {
            source = value;
        }

        if (source <= 0) {
            errorMsg.append(msg);
        }

        return this;
    }

    /**
     * 校验是否小于0
     * @param value 值
     * @param msg 错误信息
     * @return 自身引用
     */
    public ValidationUtil checkLessZero(Double value, String msg) {
        double source = NumberUtil.DOUBLE_ZERO;
        if (value != null) {
            source = value;
        }

        if (source <= NumberUtil.DOUBLE_ZERO) {
            errorMsg.append(msg);
        }

        return this;
    }
}
