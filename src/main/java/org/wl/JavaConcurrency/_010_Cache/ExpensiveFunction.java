package org.wl.JavaConcurrency._010_Cache;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger>{
    @Override
    public BigInteger compute(String arg) {
        // 执行很长时间的计算操作得到结果
        return new BigInteger(arg);
    }
}
