package com.thealgorithms.datastructures.queues;

public class CircularQueue<T> {
    private T[] array;
    private int topOfQueue;
    private int beginningOfQueue;
    private final int size;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.array = (T[]) new Object[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        this.size = size;
        this.currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == size;
    }

    public void enQueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (isEmpty()) {
            beginningOfQueue = 0;
        }
        topOfQueue = (topOfQueue + 1) % size;
        array[topOfQueue] = value;
        currentSize++;
    }

    public T deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T removedValue = array[beginningOfQueue];
        array[beginningOfQueue] = null; 
        beginningOfQueue = (beginningOfQueue + 1) % size;
        currentSize--;
        if (isEmpty()) {
            beginningOfQueue = -1;
            topOfQueue = -1;
        }
        return removedValue;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[beginningOfQueue];
    }

    public void deleteQueue() {
        array = null;
        beginningOfQueue = -1;
        topOfQueue = -1;
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }
}
