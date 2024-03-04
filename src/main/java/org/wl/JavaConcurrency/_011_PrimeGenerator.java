package org.wl.JavaConcurrency;

import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class _011_PrimeGenerator implements Runnable{
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    public void cancel() {
        this.cancelled = true;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws InterruptedException {
        _011_PrimeGenerator generator = new _011_PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(10);
        }finally {
            generator.cancel();
        }
        System.out.println(generator.get());
    }
}
