package com.thealgorithms.bitmanipulation;

public final class SingleBitOperations {
    private SingleBitOperations() {
    }

    public static int flipBit(final int num, final int bit) {
        return num ^ (1 << bit);
    }

    public static int setBit(final int num, final int bit) {
        return num | (1 << bit);
    }

    public static int clearBit(final int num, final int bit) {
        return num & ~(1 << bit);
    }

    public static int getBit(final int num, final int bit) {
        return (num >> bit) & 1;
    }
}
