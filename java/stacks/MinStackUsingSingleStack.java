package com.thealgorithms.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStackUsingSingleStack {
    private final Stack<long[]> stack = new Stack<>();

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new long[] {value, value});
        } else {
            long minSoFar = Math.min(value, stack.peek()[1]);
            stack.push(new long[] {value, minSoFar});
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return (int) stack.peek()[0];
        }
        throw new EmptyStackException();
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return (int) stack.peek()[1];
        }
        throw new EmptyStackException();
    }
}
