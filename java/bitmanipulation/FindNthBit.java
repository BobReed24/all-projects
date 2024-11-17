package com.thealgorithms.bitmanipulation;

public final class FindNthBit {

    private FindNthBit() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int findNthBit(int num, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Bit position must be greater than or equal to 1.");
        }
        
        return (num & (1 << (n - 1))) >> (n - 1);
    }
}
