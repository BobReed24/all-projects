package com.thealgorithms.datastructures.bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E> {

    private Node<E> firstElement; 
    private int size; 

    private static final class Node<E> {
        private E content;
        private Node<E> nextElement;
    }

    public Bag() {
        firstElement = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>();
        newNode.content = element;
        newNode.nextElement = firstElement;
        firstElement = newNode;
        size++;
    }

    public boolean contains(E element) {
        for (E value : this) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(firstElement);
    }

    private static class ListIterator<E> implements Iterator<E> {

        private Node<E> currentElement;

        ListIterator(Node<E> firstElement) {
            this.currentElement = firstElement;
        }

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the bag.");
            }
            E element = currentElement.content;
            currentElement = currentElement.nextElement;
            return element;
        }
    }
}
