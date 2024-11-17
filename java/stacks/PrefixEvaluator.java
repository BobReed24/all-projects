package com.thealgorithms.stacks;

import java.util.Set;
import java.util.Stack;

public final class PrefixEvaluator {
    private PrefixEvaluator() {
    }

    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(applyOperator(token, operand1, operand2));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private static int applyOperator(String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
}
