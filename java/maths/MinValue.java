package com.thealgorithms.maths;

public final class MinValue {
    private MinValue() {
    }
    
    public static int min(int a, int b) {
        return a <= b ? a : b;
    }
}
