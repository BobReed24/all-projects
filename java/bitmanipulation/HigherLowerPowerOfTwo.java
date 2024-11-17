package com.thealgorithms.bitmanipulation;

public final class HigherLowerPowerOfTwo {
    private HigherLowerPowerOfTwo() {
    }

    public static int nextHigherPowerOfTwo(int x) {
        if (x < 1) {
            return 1;
        }
        x--;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x + 1;
    }

    public static int nextLowerPowerOfTwo(int x) {
        if (x < 1) {
            return 0;
        }
        return Integer.highestOneBit(x);
    }
}
