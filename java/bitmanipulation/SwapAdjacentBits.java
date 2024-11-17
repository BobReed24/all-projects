package com.thealgorithms.bitmanipulation;

public final class SwapAdjacentBits {
    private SwapAdjacentBits() {
    }

    public static int swapAdjacentBits(int num) {
        
        int evenBits = num & 0xAAAAAAAA;

        int oddBits = num & 0x55555555;

        evenBits >>= 1;
        oddBits <<= 1;

        return evenBits | oddBits;
    }
}
