package com.thealgorithms.greedyalgorithms;

import java.util.Arrays;

public final class MinimumWaitingTime {
    private MinimumWaitingTime() {
    }

    public static int minimumWaitingTime(int[] queries) {
        int n = queries.length;
        if (n <= 1) {
            return 0;
        }

        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingTime += queries[i] * (n - i - 1);
        }
        return totalWaitingTime;
    }
}
