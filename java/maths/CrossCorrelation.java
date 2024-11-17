package com.thealgorithms.maths;

public final class CrossCorrelation {
    private CrossCorrelation() {
    }

    public static double[] crossCorrelation(double[] x, double[] y) {
        
        double[] result = new double[x.length + y.length - 1];
        int n = result.length;

        int yStart = y.length;
        for (int i = 0; i < n; i++) {
            result[i] = 0;

            int kMin = Math.max(i - (y.length - 1), 0);
            int kMax = Math.min(i, x.length - 1);

            if (i < y.length) {
                yStart--;
            }

            int count = 0;
            for (int k = kMin; k <= kMax; k++) {
                result[i] += x[k] * y[yStart + count];
                count++;
            }
        }

        return result;
    }
}
