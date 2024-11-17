package com.thealgorithms.stacks;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingTwoQueues {

    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    public StackUsingTwoQueues() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int item) {
        tempQueue.add(item);

        while (!mainQueue.isEmpty()) {
            tempQueue.add(mainQueue.remove());
        }

        Queue<Integer> swap = mainQueue;
        mainQueue = tempQueue;
        tempQueue = swap; 
    }

    public int pop() {
        if (mainQueue.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return mainQueue.remove();
    }

    public Integer peek() {
        if (mainQueue.isEmpty()) {
            return null;
        }
        return mainQueue.peek();
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public int size() {
        return mainQueue.size();
    }
}
