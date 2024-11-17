package com.thealgorithms.maths;

public final class AbsoluteMax {
    private AbsoluteMax() {
    }

    public static int getMaxValue(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty or null");
        }
        int absMax = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(numbers[i]) > Math.abs(absMax)) {
                absMax = numbers[i];
            }
        }
        return absMax;
    }
}
