package org.wl.DataStructureAlgorithm.thirdSection;

/*二分查找符号表（基于有序数组）*/
public class _015_BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public _015_BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val) {
        // 查找键，找到则更新值，否则创建新的元素
        int i = rank(key);
        if (i <= N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        // 将所有更大的键向后移动一格
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }


    /*e二分查找实现*/
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public boolean isEmpty() {
        return N == 0;
    }

}
