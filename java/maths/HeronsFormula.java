package com.thealgorithms.maths;

public final class HeronsFormula {

    private HeronsFormula() {
    }

    private static boolean areAllSidesPositive(final double a, final double b, final double c) {
        return a > 0 && b > 0 && c > 0;
    }

    private static boolean canFormTriangle(final double a, final double b, final double c) {
        return a + b > c && b + c > a && c + a > b;
    }

    public static double herons(final double a, final double b, final double c) {
        if (!areAllSidesPositive(a, b, c) || !canFormTriangle(a, b, c)) {
            throw new IllegalArgumentException("Triangle can't be formed with the given side lengths");
        }
        final double s = (a + b + c) / 2.0;
        return Math.sqrt((s) * (s - a) * (s - b) * (s - c));
    }
}
