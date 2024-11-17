package com.thealgorithms.others;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private final Stack<Object> inStack;
    private final Stack<Object> outStack;

    public QueueUsingTwoStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void insert(Object x) {
        
        this.inStack.push(x);
    }

    public Object remove() {
        if (this.outStack.isEmpty()) {
            
            while (!this.inStack.isEmpty()) {
                this.outStack.push(this.inStack.pop());
            }
        }
        return this.outStack.pop();
    }

    public Object peekFront() {
        if (this.outStack.isEmpty()) {
            
            while (!this.inStack.isEmpty()) {
                this.outStack.push(this.inStack.pop());
            }
        }
        return this.outStack.peek();
    }

    public Object peekBack() {
        return this.inStack.peek();
    }

    public boolean isEmpty() {
        return (this.inStack.isEmpty() && this.outStack.isEmpty());
    }

    public boolean isInStackEmpty() {
        return (inStack.isEmpty());
    }

    public boolean isOutStackEmpty() {
        return (outStack.isEmpty());
    }
}
