package com.uptool.core.util;

/**
 * @Description: 相等工具类
 * @Author chenfuyuan
 * @Date 2021/3/19 15:52
 */
public class EqualUtil {

    /**
     * 校验resousceList 是否都等于obj
     * @param obj 校验对象
     * @param resourceList 校验资源
     * @return 校验结果
     */
    public static boolean allEquals(String obj,String...resourceList) {
        if (obj == null || resourceList == null) {
            return false;
        }

        for (String resource : resourceList) {
            if (!obj.equals(resource)) {
                return false;
            }
        }

        return true;
    }



    /**
     * 校验resousceList 是否都等于obj
     * @param obj 校验对象
     * @param resourceList 校验资源
     * @return 校验结果
     */
    public static boolean oneEquals(String obj,String...resourceList) {
        if (obj == null || resourceList == null) {
            return false;
        }

        for (String resource : resourceList) {
            if (obj.equals(resource)) {
                return true;
            }
        }

        return false;
    }
}
