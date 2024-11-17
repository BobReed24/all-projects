package com.thealgorithms.bitmanipulation;

public final class IndexOfRightMostSetBit {

    private IndexOfRightMostSetBit() {
    }

    public static int indexOfRightMostSetBit(int n) {
        if (n == 0) {
            return -1; 
        }

        if (n < 0) {
            n = -n;
            n = n & (~n + 1); 
        }

        int index = 0;
        while ((n & 1) == 0) {
            n = n >> 1;
            index++;
        }

        return index;
    }
}
