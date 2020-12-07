package cn.tianyi.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlgorithmTest {
    @DisplayName("BloomFilterTest")
    @Test
    void BloomFilterTest() {
        for (int i = 0; i < 100000000; i++){
            BloomFilter.add(String.valueOf(i));
        }
        String id = "123456789";
        BloomFilter.add(id);
        long start = System.currentTimeMillis();
        Assertions.assertTrue(BloomFilter.contains(id));
        System.out.println("cost is " + (System.currentTimeMillis() - start));
        Assertions.assertFalse(BloomFilter.contains("234567890"));
    }
}
