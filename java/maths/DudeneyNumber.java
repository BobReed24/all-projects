package com.thealgorithms.maths;

public final class DudeneyNumber {
    private DudeneyNumber() {
    }

    public static boolean isDudeney(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must me positive.");
        }
        
        final int cubeRoot = (int) Math.round(Math.pow(n, 1.0 / 3.0));
        
        if (cubeRoot * cubeRoot * cubeRoot != n) {
            return false;
        }

        return cubeRoot == SumOfDigits.sumOfDigits(n);
    }
}
