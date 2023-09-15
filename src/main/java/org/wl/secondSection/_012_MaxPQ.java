package org.wl.secondSection;

/*
 * 优先队列
 */
public class _012_MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; //基于堆的完全二叉树
    private int N = 0; // 存储于pq[1..N]中，pq[0]没有使用

    public _012_MaxPQ() {
    }

    public _012_MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }


    public _012_MaxPQ(Key[] a) {
    }

    /*
     向优先队列中插入一个元素
      */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }


    /*
    返回最大元素
     */
    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null; //避免游离
        sink(1);
        return max;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /*
    由下至上的堆有序化(上浮)的实现
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /*
    由上至下的堆有序化(下沉)的实现
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        _012_MaxPQ<Integer> maxPQ = new _012_MaxPQ<>(10);
        maxPQ.insert(1);
        maxPQ.insert(6);
        maxPQ.insert(9);
        maxPQ.insert(2);
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
        }
    }
}
