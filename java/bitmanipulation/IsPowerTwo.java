package com.thealgorithms.bitmanipulation;

public final class IsPowerTwo {
    private IsPowerTwo() {
    }

    public static boolean isPowerTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int ans = number & (number - 1);
        return ans == 0;
    }
}
