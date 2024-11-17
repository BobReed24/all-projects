package com.thealgorithms.stacks;

import java.util.Stack;

public final class NextGreaterElement {
    private NextGreaterElement() {
    }

    public static int[] findNextGreaterElements(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                result[stack.pop()] = array[i];
            }
            stack.push(i);
        }

        return result;
    }
}
