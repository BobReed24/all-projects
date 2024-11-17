package com.thealgorithms.maths;

public final class ReverseNumber {
    private ReverseNumber() {
    }

    public static int reverseNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("number must be nonnegative.");
        }

        int result = 0;
        while (number > 0) {
            result *= 10;
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}
