package com.thealgorithms.stacks;

import java.util.Stack;

public final class SortStack {
    private SortStack() {
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, element);
        stack.push(top);
    }
}
