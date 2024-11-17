package com.thealgorithms.bitmanipulation;

public final class NextHigherSameBitCount {
    private NextHigherSameBitCount() {
    }

    public static int nextHigherSameBitCount(int n) {
        int c = n & -n;
        int r = n + c;
        return (((r ^ n) >> 2) / c) | r;
    }
}
