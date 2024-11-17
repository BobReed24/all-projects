package com.thealgorithms.stacks;

import java.util.Stack;

public final class DuplicateBrackets {
    private DuplicateBrackets() {
    }

    public static boolean check(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("Input expression cannot be null.");
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    return true;
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return false;
    }
}
