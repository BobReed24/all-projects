package com.thealgorithms.maths;

public final class SumOfArithmeticSeries {
    private SumOfArithmeticSeries() {
    }

    public static double sumOfSeries(final double firstTerm, final double commonDiff, final int numOfTerms) {
        if (numOfTerms < 0) {
            throw new IllegalArgumentException("numOfTerms nonnegative.");
        }
        return (numOfTerms / 2.0 * (2 * firstTerm + (numOfTerms - 1) * commonDiff));
    }
}
