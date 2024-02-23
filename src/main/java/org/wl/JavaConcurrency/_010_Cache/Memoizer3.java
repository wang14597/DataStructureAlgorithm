package org.wl.JavaConcurrency._010_Cache;

import java.util.Map;
import java.util.concurrent.*;

/*
* 使用FutureTask创建异步任务。若其他线程正在计算结果，则新到的线程将等待结果计算出来
* 缺点：仍然存在重复计算的问题，只是概率比Memoizer2小很多
*/
public class Memoizer3<A, V> implements Computable<A,V>{
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }
    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f==null) {
            Callable<V> callable = () -> c.compute(arg);
            FutureTask<V> ft = new FutureTask<>(callable);
            f = ft;
            cache.put(arg, ft);
            ft.run(); // 执行c.compute
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
