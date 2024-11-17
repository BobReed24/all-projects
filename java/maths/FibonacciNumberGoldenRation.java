package com.thealgorithms.maths;

public final class FibonacciNumberGoldenRation {
    private FibonacciNumberGoldenRation() {
        
    }

    public static final int MAX_ARG = 70;

    public static long compute(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input 'n' must be a non-negative integer.");
        }

        if (n > MAX_ARG) {
            throw new IllegalArgumentException("Input 'n' is too big to give accurate result.");
        }

        if (n <= 1) {
            return n;
        }

        final double sqrt5 = Math.sqrt(5);
        final double phi = (1 + sqrt5) / 2;
        final double psi = (1 - sqrt5) / 2;
        final double result = (Math.pow(phi, n) - Math.pow(psi, n)) / sqrt5;

        return Math.round(result);
    }
}
