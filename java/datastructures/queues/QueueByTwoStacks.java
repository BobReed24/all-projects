package com.thealgorithms.datastructures.queues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueByTwoStacks<T> {

    private final Stack<T> enqueueStk;
    private final Stack<T> dequeueStk;

    public QueueByTwoStacks() {
        enqueueStk = new Stack<>();
        dequeueStk = new Stack<>();
    }

    public void put(T item) {
        enqueueStk.push(item);
    }

    public T get() {
        if (dequeueStk.isEmpty()) {
            while (!enqueueStk.isEmpty()) {
                dequeueStk.push(enqueueStk.pop());
            }
        }
        if (dequeueStk.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return dequeueStk.pop();
    }

    public int size() {
        return enqueueStk.size() + dequeueStk.size();
    }

    @Override
    public String toString() {
        Stack<T> tempStack = (Stack<T>) dequeueStk.clone();
        while (!enqueueStk.isEmpty()) {
            tempStack.push(enqueueStk.pop());
        }
        return "Queue(" + tempStack + ")";
    }
}
