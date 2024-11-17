package com.thealgorithms.bitmanipulation;

public final class ModuloPowerOfTwo {
    private ModuloPowerOfTwo() {
    }

    public static int moduloPowerOfTwo(int x, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The exponent must be positive");
        }

        return x & ((1 << n) - 1);
    }
}
