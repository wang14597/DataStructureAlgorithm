package org.wl.DataStructureAlgorithm.thirdSection;

/*符号表（字典）*/
public class _013_ST<Key extends Comparable<Key>, Value> {
    public _013_ST() {
    }

    void put(Key key, Value value) {

    }

    Value get(Key key) {
        return null;
    }

    void delete(Key key) {

    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return 0;
    }

    int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) return 0;
        else if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    Key min() {
        return null;
    }

    Key max() {
        return null;
    }

    /*小于等于 key 的最大键*/
    Key floor(Key key) {
        return null;
    }

    /*大于等于 key 的最小键*/
    Key ceiling(Key key) {
        return null;
    }

    /*小于 key 的键的数量*/
    int rank(Key key) {
        return 0;
    }

    /*排名为k的键*/
    Key select(int k) {
        return null;
    }

    void deleteMin() {
        delete(min());
    }

    void deleteMax() {
        delete(max());
    }

    Iterable<Key> keys() {
        return null;
    }

    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }
}
