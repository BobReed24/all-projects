package com.thealgorithms.maths;

public final class Combinations {
    private Combinations() {
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
    }

    public static long combinations(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static long combinationsOptimized(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("n or k can't be negative");
        }
        if (n < k) {
            throw new IllegalArgumentException("n can't be smaller than k");
        }
        
        long solution = 1;
        for (int i = 0; i < k; i++) {
            solution = (n - i) * solution / (i + 1);
        }
        return solution;
    }
}
