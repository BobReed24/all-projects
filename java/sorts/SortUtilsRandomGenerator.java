package com.thealgorithms.sorts;

import java.util.Random;

public final class SortUtilsRandomGenerator {
    private SortUtilsRandomGenerator() {
    }

    private static final Random RANDOM;
    private static final long SEED;

    static {
        SEED = System.currentTimeMillis();
        RANDOM = new Random(SEED);
    }

    public static Double[] generateArray(int size) {
        Double[] arr = new Double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = generateDouble();
        }
        return arr;
    }

    public static Double generateDouble() {
        return RANDOM.nextDouble();
    }

    public static int generateInt(int n) {
        return RANDOM.nextInt(n);
    }
}
