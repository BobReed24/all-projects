package com.thealgorithms.stacks;

import java.util.Arrays;
import java.util.Stack;

public final class NextSmallerElement {
    private NextSmallerElement() {
    }

    public static int[] findNextSmallerElements(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < array.length; i++) {
            
            while (!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(array[i]);
        }

        return result;
    }
}
