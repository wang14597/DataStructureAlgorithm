package org.wl.JavaConcurrency._010_Cache;

public interface Computable <A,V>{
    V compute(A arg) throws InterruptedException;
}
