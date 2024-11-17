package com.thealgorithms.maths;

public final class PowerOfTwoOrNot {
    private PowerOfTwoOrNot() {
    }

    public static boolean checkIfPowerOfTwoOrNot(final int number) {
        return number != 0 && ((number & (number - 1)) == 0);
    }
}
