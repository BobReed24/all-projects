package com.thealgorithms.others;

import java.util.Stack;

public final class ReverseStackUsingRecursion {
    private ReverseStackUsingRecursion() {
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack cannot be null");
        }
        if (!stack.isEmpty()) {
            int topElement = stack.pop();
            reverse(stack);
            insertAtBottom(stack, topElement);
        }
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int topElement = stack.pop();
            insertAtBottom(stack, element);
            stack.push(topElement);
        }
    }
}
