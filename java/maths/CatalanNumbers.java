package com.thealgorithms.maths;

public final class CatalanNumbers {
    private CatalanNumbers() {
    }

    public static long catalan(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        return factorial(2 * n) / (factorial(n + 1) * factorial(n));
    }

    private static long factorial(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
