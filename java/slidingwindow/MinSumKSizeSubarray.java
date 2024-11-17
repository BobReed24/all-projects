package com.thealgorithms.slidingwindow;

public final class MinSumKSizeSubarray {

    private MinSumKSizeSubarray() {
    }

    public static int minSumKSizeSubarray(int[] arr, int k) {
        if (arr.length < k) {
            return -1; 
        }

        int minSum;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        minSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            minSum = Math.min(minSum, windowSum);
        }
        return minSum;
    }
}
