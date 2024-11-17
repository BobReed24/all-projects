package com.thealgorithms.maths;

public final class BinaryPow {
    private BinaryPow() {
    }

    public static int binPow(int a, int p) {
        int res = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = res * a;
            }
            a = a * a;
            p >>>= 1;
        }
        return res;
    }
}
