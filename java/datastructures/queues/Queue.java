package com.thealgorithms.datastructures.queues;

public final class Queue<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private final int maxSize;
    private final Object[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue capacity must be greater than 0");
        }
        this.maxSize = capacity;
        this.queueArray = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public boolean insert(T element) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = element;
        nItems++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot remove element");
        }
        T removedElement = (T) queueArray[front];
        queueArray[front] = null; 
        front = (front + 1) % maxSize;
        nItems--;
        return removedElement;
    }

    @SuppressWarnings("unchecked")
    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot peek front");
        }
        return (T) queueArray[front];
    }

    @SuppressWarnings("unchecked")
    public T peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot peek rear");
        }
        return (T) queueArray[rear];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int getSize() {
        return nItems;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nItems; i++) {
            int index = (front + i) % maxSize;
            sb.append(queueArray[index]).append(", ");
        }
        sb.setLength(sb.length() - 2); 
        sb.append("]");
        return sb.toString();
    }
}
