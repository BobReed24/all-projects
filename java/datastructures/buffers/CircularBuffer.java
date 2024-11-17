package com.thealgorithms.datastructures.buffers;

import java.util.concurrent.atomic.AtomicInteger;

public class CircularBuffer<Item> {
    private final Item[] buffer;
    private final CircularPointer putPointer;
    private final CircularPointer getPointer;
    private final AtomicInteger size = new AtomicInteger(0);

    public CircularBuffer(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }
        
        this.buffer = (Item[]) new Object[size];
        this.putPointer = new CircularPointer(0, size);
        this.getPointer = new CircularPointer(0, size);
    }

    public boolean isEmpty() {
        return size.get() == 0;
    }

    public boolean isFull() {
        return size.get() == buffer.length;
    }

    public Item get() {
        if (isEmpty()) {
            return null;
        }

        Item item = buffer[getPointer.getAndIncrement()];
        size.decrementAndGet();
        return item;
    }

    public boolean put(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null items are not allowed");
        }

        boolean wasEmpty = isEmpty();
        if (isFull()) {
            getPointer.getAndIncrement(); 
        } else {
            size.incrementAndGet();
        }

        buffer[putPointer.getAndIncrement()] = item;
        return wasEmpty;
    }

    private static class CircularPointer {
        private int pointer;
        private final int max;

        CircularPointer(int pointer, int max) {
            this.pointer = pointer;
            this.max = max;
        }

        public int getAndIncrement() {
            int tmp = pointer;
            pointer = (pointer + 1) % max;
            return tmp;
        }
    }
}
