package org.wl.JavaConcurrency._010_Cache;

import net.jcip.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/*
* hashmap线程不安全，Memoizer1采用保守的方法，即对整个
* compute方法进行同步，保证了线程安全。
* 缺点：另一个线程正在计算，则其他调用compute将被阻塞很久。
*/
public class Memoizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
