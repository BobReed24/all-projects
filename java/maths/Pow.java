package com.thealgorithms.maths;

public final class Pow {
    private Pow() {
    }

    public static long pow(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative.");
        }
        long result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }
}
