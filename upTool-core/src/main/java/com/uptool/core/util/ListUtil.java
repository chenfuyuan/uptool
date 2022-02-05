package com.uptool.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * List工具类
 *
 * @author chenfuyuan
 * @date 2022/2/4 15:39
 */
public class ListUtil {

    public static<T,R> List<R> listMapCollectToList(List<T> list, Function<T, ? extends R> mapper){
        if (EmptyUtil.isEmpty(list)) {
            return new ArrayList<R>();
        }

        return list.stream().map(mapper).collect(Collectors.toList());
    }
}
