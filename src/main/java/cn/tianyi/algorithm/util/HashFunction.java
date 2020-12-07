package cn.tianyi.algorithm.util;

public class HashFunction {
    private int size;
    private int seed;

    public HashFunction(int size, int seed){
        this.size = size;
        this.seed = seed;
    }

    public int hash(String value){
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++){
            result = seed * result +value.charAt(i);
        }

        return (size -1) & result;
    }
}
