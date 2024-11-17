package com.thealgorithms.bitmanipulation;

public final class HammingDistance {
    private HammingDistance() {
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }
}
