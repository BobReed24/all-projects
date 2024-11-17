package com.thealgorithms.bitmanipulation;

public final class ReverseBits {
    private ReverseBits() {
    }

    public static int reverseBits(int n) {
        int result = 0;
        int bitCount = 32;
        for (int i = 0; i < bitCount; i++) {
            result <<= 1; 
            result |= (n & 1); 
            n >>= 1; 
        }
        return result;
    }
}
