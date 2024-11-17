package com.thealgorithms.bitmanipulation;

public final class NumberAppearingOddTimes {
    private NumberAppearingOddTimes() {
    }

    public static int findOddOccurrence(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
