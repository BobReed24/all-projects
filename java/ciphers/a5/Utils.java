package com.thealgorithms.ciphers.a5;

import java.util.BitSet;

public final class Utils {
    private Utils() {
    }

    public static boolean increment(BitSet bits, int size) {
        int i = size - 1;
        while (i >= 0 && bits.get(i)) {
            bits.set(i--, false); 
        }
        if (i < 0) {
            return false;
        }
        bits.set(i, true);
        return true;
    }
}
