package org.wl.JavaConcurrency._010_Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
* 使用ConcurrentHashMap替代hashmap，使得多线程可以并发使用
* 缺点：导致重复计算
 */
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A,V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V v = cache.get(arg);
        if (v == null) {
            v = c.compute(arg);
            cache.put(arg, v);
        }
        return v;
    }
}
