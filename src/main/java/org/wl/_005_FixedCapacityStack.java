package org.wl;

/*
泛型定容栈
*/
public class _005_FixedCapacityStack<Item> {

    private final Item[] a; // stack entries
    private int N = 0; // size

    public _005_FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        _005_FixedCapacityStack<Integer> s = new _005_FixedCapacityStack<>(10);
        s.push(1);
        s.push(2);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }

}
