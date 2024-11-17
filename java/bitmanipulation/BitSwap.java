package com.thealgorithms.bitmanipulation;

public final class BitSwap {
    private BitSwap() {
    }
    
    public static int bitSwap(int data, final int posA, final int posB) {
        if (SingleBitOperations.getBit(data, posA) != SingleBitOperations.getBit(data, posB)) {
            data ^= (1 << posA) ^ (1 << posB);
        }
        return data;
    }
}
