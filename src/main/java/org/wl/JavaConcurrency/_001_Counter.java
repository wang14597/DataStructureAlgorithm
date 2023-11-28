package org.wl.JavaConcurrency;

/*监视器模式的线程安全计数器*/

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class _001_Counter {
    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
