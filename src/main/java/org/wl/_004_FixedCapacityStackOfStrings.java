package org.wl;

/*
定容栈
*/
public class _004_FixedCapacityStackOfStrings {

    private final String[] a; // stack entries
    private int N = 0; // size

    public _004_FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        _004_FixedCapacityStackOfStrings s;
        s = new _004_FixedCapacityStackOfStrings(10);
        s.push("w");
        s.push("l");
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }

}
