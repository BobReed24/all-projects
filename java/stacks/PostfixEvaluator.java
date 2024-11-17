package com.thealgorithms.stacks;

import java.util.Set;
import java.util.Stack;

public final class PostfixEvaluator {
    private PostfixEvaluator() {
    }

    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (String token : expression.split("\\s+")) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
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
