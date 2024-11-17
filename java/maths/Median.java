package com.thealgorithms.maths;

import java.util.Arrays;

public final class Median {
    private Median() {
    }

    public static double median(int[] values) {
        Arrays.sort(values);
        int length = values.length;
        return length % 2 == 0 ? (values[length / 2] + values[length / 2 - 1]) / 2.0 : values[length / 2];
    }
}
