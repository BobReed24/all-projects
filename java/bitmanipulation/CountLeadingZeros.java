package com.thealgorithms.bitmanipulation;

public final class CountLeadingZeros {
    private CountLeadingZeros() {
    }

    public static int countLeadingZeros(int num) {
        if (num == 0) {
            return 32;
        }

        int count = 0;
        int mask = 1 << 31;
        while ((mask & num) == 0) {
            count++;
            mask >>>= 1;
        }

        return count;
    }
}
