package com.thealgorithms.maths;

public final class FactorialRecursion {
    private FactorialRecursion() {
    }
    
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
    }
}
