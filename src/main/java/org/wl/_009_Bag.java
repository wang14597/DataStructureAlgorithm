package org.wl;

import java.util.Iterator;

public class _009_Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public static void main(String[] args) {
        _009_Bag<Integer> bag = new _009_Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        for (Integer i : bag) {
            System.out.println(i);

        }
    }
}
