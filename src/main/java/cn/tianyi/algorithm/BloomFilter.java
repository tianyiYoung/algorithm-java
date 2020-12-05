package cn.tianyi.algorithm;

import org.graalvm.compiler.lir.hashing.HashFunction;

import java.util.BitSet;

/**
 * A Bloom filter is a data structure designed to tell you,
 * rapidly and memory-efficiently, whether an element is present in a set.
 * The price paid for this efficiency is that a Bloom filter is a probabilistic data structure:
 * it tells us that the element either definitely is not in the set or may be in the set.
 * @author 550448928@qq.com (tianyi)
 */
public class BloomFilter {
    /**
     * 一个长度为10 亿的比特位
     */
    private static final int DEFAULT_SIZE = 256 << 22;

    /**
     * 为了降低错误率，使用加法hash算法，所以定义一个8个元素的质数数组
     */
    private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};

    /**
     * 相当于构建 8 个不同的hash算法
     */
    private static HashFunction[] functions = new HashFunction[seeds.length];

    /**
     * 初始化布隆过滤器的 bitmap
     */
    private static BitSet bitset = new BitSet(DEFAULT_SIZE);

    public static void add(String value){
        if(value != null){
            for(HashFunction f : functions){
                bitset.set(f.hashCode(),true);
            }
        }
    }
}
