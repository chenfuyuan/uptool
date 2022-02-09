package com.uptool.core.cache;

import com.uptool.core.Exception.ValidationException;

import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @author chenfuyuan
 * @date 2022/2/9 17:09
 */
public class BloomFilter<T> {

    /**
     * 位数组的默认大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;

    /**
     * 位数组
     */
    private BitSet bitSet = new BitSet(DEFAULT_SIZE);

    /**
     * 通过这个数组可以创建6个不同的哈希函数
     */
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    /**
     * 存放包含 hash 函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 静态内部类-用于hash操作
     */
    public static class SimpleHash<T>{
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算hash值
         * @param value
         * @return
         */
        public int hash(T value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }

    public BloomFilter() {
        // 初始化多个不同的Hash函数
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     * @param element 元素
     */
    public void add(T element) {
        // 遍历哈希函数数组，分别计算哈希值
        for (SimpleHash f : func) {
            bitSet.set(f.hash(element),true);
        }
    }

    /**
     * 判断指定元素是否存在于位数组
     * @param element 元素
     * @return 是否存在于位数组
     */
    public boolean contains(T element) {
        boolean ret = true;
        for (SimpleHash f : func) {
            //计算hash值，当存在位数组中的所有对应位置都为true时
            ret = ret && bitSet.get(f.hash(element));
        }
        return ret;
    }


}
