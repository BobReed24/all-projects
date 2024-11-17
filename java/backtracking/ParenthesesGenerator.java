package com.thealgorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public final class ParenthesesGenerator {
    private ParenthesesGenerator() {
    }

    public static List<String> generateParentheses(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of pairs of parentheses cannot be negative");
        }
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, "", 0, 0, n);
        return result;
    }

    private static void generateParenthesesHelper(List<String> result, final String current, final int open, final int close, final int n) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        if (open < n) {
            generateParenthesesHelper(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generateParenthesesHelper(result, current + ")", open, close + 1, n);
        }
    }
}
