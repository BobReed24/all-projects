package com.thealgorithms.bitmanipulation;

public final class NumbersDifferentSigns {
    private NumbersDifferentSigns() {
    }

    public static boolean differentSigns(int num1, int num2) {
        return (num1 ^ num2) < 0;
    }
}
