package com.thealgorithms.datastructures.stacks;

import java.util.Stack;

public final class ReverseStack {
    private ReverseStack() {
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int element = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, element);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int topElement = stack.pop();
        insertAtBottom(stack, element);
        stack.push(topElement);
    }
}
