package com.thealgorithms.conversions;

public final class EndianConverter {
    private EndianConverter() {
    }

    public static int bigToLittleEndian(int value) {
        return Integer.reverseBytes(value);
    }

    public static int littleToBigEndian(int value) {
        return Integer.reverseBytes(value);
    }
}
