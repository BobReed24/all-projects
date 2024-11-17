package com.thealgorithms.bitmanipulation;

public final class NonRepeatingNumberFinder {
    private NonRepeatingNumberFinder() {
    }

    public static int findNonRepeatingNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
