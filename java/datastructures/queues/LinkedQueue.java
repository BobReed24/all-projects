package com.thealgorithms.datastructures.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Iterable<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front; 
    private Node<T> rear; 
    private int size; 

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot enqueue null data");
        }

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T retValue = front.data;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return retValue;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return rear.data;
    }

    public T peek(int pos) {
        if (pos < 1 || pos > size) {
            throw new IndexOutOfBoundsException("Position " + pos + " out of range!");
        }

        Node<T> node = front;
        for (int i = 1; i < pos; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
