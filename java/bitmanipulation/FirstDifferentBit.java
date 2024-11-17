package com.thealgorithms.bitmanipulation;

public final class FirstDifferentBit {
    private FirstDifferentBit() {
    }

    public static int firstDifferentBit(int x, int y) {
        int diff = x ^ y;
        return Integer.numberOfTrailingZeros(diff);
    }
}
