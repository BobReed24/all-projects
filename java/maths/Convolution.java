package com.thealgorithms.maths;

public final class Convolution {
    private Convolution() {
    }

    public static double[] convolution(double[] a, double[] b) {
        double[] convolved = new double[a.length + b.length - 1];

        for (int i = 0; i < convolved.length; i++) {
            convolved[i] = 0;
            int k = Math.max(i - b.length + 1, 0);

            while (k < i + 1 && k < a.length) {
                convolved[i] += a[k] * b[i - k];
                k++;
            }
        }

        return convolved;
    }
}
