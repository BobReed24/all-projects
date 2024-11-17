package com.thealgorithms.maths;

public final class AutoCorrelation {
    private AutoCorrelation() {
    }

    public static double[] autoCorrelation(double[] x) {

        return CrossCorrelation.crossCorrelation(x, x);
    }
}
