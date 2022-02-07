package com.uptool.core.util;

/**
 * @Description: 排序工具类
 * @Author chenfuyuan
 * @Date 2021/3/24 14:36
 */
public class SortUtil {


    /**
     * 比较值相等-0
     */
    public static final int COMPARETO_EQUAL = 0;

    /**
     * 比较值 num1 < num2 标识
     */
    public static final int COMPARETO_LESS = -1;

    /**
     * 比较值 num1 > num2 标识
     */
    public static final int COMPARETO_MORE = 1;

    /**
     * 两则进行比较，判断obj1是否小于obj2
     * @param obj1 比较对象
     * @param obj2 比较对象
     * @return true:小于
     */
    public static boolean less(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) < COMPARETO_EQUAL;
    }

    public static int compare(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2);
    }

    /**
     * 两个Intger对象进行比较，如果该对象为空，则默认为0
     * @param num1 比较对象1
     * @param num2 比较对象2
     * @return
     */
    public static int compareNullToZero(Integer num1, Integer num2) {
        return compareNullToDefault(num1, num2, 0);
    }

    /**
     * 两个Ineger对象进行比较，如果该对象为空，则采用默认值
     * @param num1 比较对象1
     * @param num2 比较对象2
     * @param defaultNum 默认值
     * @return
     */
    public static int compareNullToDefault(Integer num1, Integer num2, Integer defaultNum) {
        return compare(num1 == null ? defaultNum : num1, num2 == null ? defaultNum : num2);
    }

    /**
     * 两则进行比较，判断obj1是否等于obj2
     * @param obj1 比较对象
     * @param obj2 比较对象
     * @return true:等于
     */
    public static boolean equal(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) == COMPARETO_EQUAL;
    }

    /**
     * 两则进行比较，判断obj1是否大于obj2
     * @param obj1 比较对象
     * @param obj2 比较对象
     * @return true:大于
     */
    public static boolean more(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) > COMPARETO_EQUAL;
    }


    /**
     * 交换次序
     * @param a 交换数据源
     * @param i 交换索引1
     * @param j 交换索引2
     */
    public static void exch(Comparable<?>[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable<?>t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 使用位运算交换次序，提高效率
     * @param a 交换数据源
     * @param i 交换索引1
     * @param j 交换索引2
     */
    public static void exch(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    /**
     * 使用位运算交换次序，提高效率
     * @param a 交换数据源
     * @param i 交换索引1
     * @param j 交换索引2
     */
    public static void exch(long[] a, int i, int j) {
        if (i == j) {
            return;
        }
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }


    /**
     * 遍历展现数组
     * @param array 数组
     */
    public static void show(Comparable<?>[] array) {

        //单行打印数组
        for (Comparable<?> comparable : array) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    /**
     * 遍历展现数组(从low到hight)
     * @param array 数组
     * @param startIndex 开始索引
     * @param length 长度
     */
    public static void show(Comparable<?>[] array,int startIndex,int length) {
        int endIndex = getEndIndex(startIndex,array.length,length);
        //单行打印数组
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断是否有序
     * @param array 数组
     * @return 是否有序
     */
    public static boolean isSorted(Comparable<?>[] array) {
        return isSorted(array, ArrayUtil.START_INDEX, array.length);
    }

    /**
     * 判断是否有序(从low到hight位置判断)
     * @param array 数组
     ** @param startIndex 低索引
     ** @param length 排序长度
     * @return 是否有序
     */
    public static boolean isSorted(Comparable<?>[] array,int startIndex ,int length) {
        int endIndex = getEndIndex(startIndex, array.length, length);

        if (length<=1 || array.length<=1) {
            return true;
        }

        for (int i = startIndex+1; i <= endIndex; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 根据开始索引和数组长度及所要操作的长度算出结束索引
     * @param startIndex 开始索引
     * @param arrayLength 数组长度
     * @param length 操作长度
     * @return 结束索引
     */
    public static int getEndIndex(int startIndex,int arrayLength,int length) {
        if (length <= 0) {
            throw new ArrayIndexOutOfBoundsException("操作的数组长度小于等于0");
        }
        int result = Math.min(arrayLength, startIndex + length) - 1;
        if (result < 0) {
            throw new ArrayIndexOutOfBoundsException("结束索引出现越界情况;");
        }
        return result;
    }
}
