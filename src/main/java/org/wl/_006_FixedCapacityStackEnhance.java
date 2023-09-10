package org.wl;

/*
泛型定容栈，在_005的基础上增加了扩容能力
*/
public class _006_FixedCapacityStackEnhance<Item> {

    private Item[] a; // stack entries
    private int N = 0; // size

    public _006_FixedCapacityStackEnhance(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        if (a.length == N) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null; // 避免对象游离

        // 大小是否小于数组的四分之一, 在数组长度被减半之后，它的状态约为半满，在下次需要改变数组大小之前仍然能够进行多次 push() 和 pop() 操作。
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String[] args) {
        _006_FixedCapacityStackEnhance<Integer> s = new _006_FixedCapacityStackEnhance<>(10);
        s.push(1);
        s.push(2);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }

}
