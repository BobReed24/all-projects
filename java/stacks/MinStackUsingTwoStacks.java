package com.thealgorithms.stacks;

import java.util.Stack;

public final class MinStackUsingTwoStacks {
    MinStackUsingTwoStacks() {
    }

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
