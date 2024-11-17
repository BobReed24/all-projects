package com.thealgorithms.maths;

public final class SumOfOddNumbers {
    private SumOfOddNumbers() {
    }

    public static int sumOfFirstNOddNumbers(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
        return n * n;
    }
}
