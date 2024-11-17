package com.thealgorithms.slidingwindow;

public final class MaxSumKSizeSubarray {

    private MaxSumKSizeSubarray() {
    }

    public static int maxSumKSizeSubarray(int[] arr, int k) {
        if (arr.length < k) {
            return -1; 
        }

        int maxSum;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
