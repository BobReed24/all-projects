package com.thealgorithms.bitmanipulation;

public final class ClearLeftmostSetBit {
    private ClearLeftmostSetBit() {
    }

    public static int clearLeftmostSetBit(int num) {
        int pos = 0;
        int temp = num;
        while (temp > 0) {
            temp >>= 1;
            pos++;
        }

        int mask = ~(1 << (pos - 1));
        return num & mask;
    }
}
