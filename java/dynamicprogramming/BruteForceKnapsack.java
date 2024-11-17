package com.thealgorithms.dynamicprogramming;

public final class BruteForceKnapsack {
    private BruteForceKnapsack() {
    }

    static int knapSack(int w, int[] wt, int[] val, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] > w) {
            return knapSack(w, wt, val, n - 1);
        } else {
            return Math.max(knapSack(w, wt, val, n - 1), val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1));
        }
    }
}
