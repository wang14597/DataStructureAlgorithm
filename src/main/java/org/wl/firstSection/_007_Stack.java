package org.wl.firstSection;

import java.util.Iterator;

public class _007_Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;
        first = newFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

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

        @Override
        public void remove() {
        }
    }

    public static void main(String[] args) {
        _007_Stack<String> stack = new _007_Stack<>();
        stack.push("4");
        stack.push("3");
        stack.push("2");
        stack.push("1");

        String pop = stack.pop();
        System.out.println(pop);

        for (String s : stack) {
            System.out.println(s);
        }

    }
}