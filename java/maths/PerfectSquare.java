package com.thealgorithms.maths;

public final class PerfectSquare {
    private PerfectSquare() {
    }

    public static boolean isPerfectSquare(final int number) {
        final int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public static boolean isPerfectSquareUsingPow(long number) {
        long a = (long) Math.pow(number, 1.0 / 2);
        return a * a == number;
    }
}
