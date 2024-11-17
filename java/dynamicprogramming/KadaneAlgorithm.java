package com.thealgorithms.dynamicprogramming;

public final class KadaneAlgorithm {
    private KadaneAlgorithm() {
    }

    public static boolean maxSum(int[] a, int predictedAnswer) {
        int sum = a[0];
        int runningSum = 0;

        for (int k : a) {
            runningSum += k;
            sum = Math.max(sum, runningSum);
            if (runningSum < 0) {
                runningSum = 0;
            }
        }

        return sum == predictedAnswer;
    }
}
