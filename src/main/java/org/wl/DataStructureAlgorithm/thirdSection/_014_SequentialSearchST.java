package org.wl.DataStructureAlgorithm.thirdSection;

import java.util.Iterator;

/*顺序查找（基于无序链表）的符号表（字典）*/
public class _014_SequentialSearchST<Key, Value> {
    private Node first;

    private int N = 0;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        if (first != null && key.equals(first.key)) {
            first = first.next;
            N--;
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
                N--;
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        return new KeysIterable();
    }

    private class KeysIterable implements Iterable<Key> {
        @Override
        public Iterator<Key> iterator() {
            return new KeysIterator();
        }
    }

    private class KeysIterator implements Iterator<Key> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Key next() {
            Key key = current.key;
            current = current.next;
            return key;
        }
    }

    public static void main(String[] args) {
        _014_SequentialSearchST<String, Integer> searchST = new _014_SequentialSearchST<>();
        searchST.put("a", 1);
        searchST.put("b", 2);
        searchST.put("c", 3);
        searchST.put("a", 4);

        for (String s : searchST.keys()) {
            System.out.println(s);
        }

        System.out.println(searchST.get("a"));
        System.out.println(searchST.size());

        searchST.delete("a");
        System.out.println(searchST.size());

        searchST.delete("b");
        System.out.println(searchST.size());

        searchST.delete("c");
        System.out.println(searchST.size());
    }
}
