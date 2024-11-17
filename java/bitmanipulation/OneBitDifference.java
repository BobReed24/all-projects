package com.thealgorithms.bitmanipulation;

public final class OneBitDifference {
    private OneBitDifference() {
    }

    public static boolean differByOneBit(int x, int y) {
        if (x == y) {
            return false;
        }

        int xor = x ^ y;
        return (xor & (xor - 1)) == 0;
    }
}
