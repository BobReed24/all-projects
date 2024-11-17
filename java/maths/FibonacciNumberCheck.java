package com.thealgorithms.maths;

public final class FibonacciNumberCheck {
    private FibonacciNumberCheck() {
    }
    
    public static boolean isPerfectSquare(long number) {
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public static boolean isFibonacciNumber(long number) {
        long value1 = 5 * number * number + 4;
        long value2 = 5 * number * number - 4;
        return isPerfectSquare(value1) || isPerfectSquare(value2);
    }
}
