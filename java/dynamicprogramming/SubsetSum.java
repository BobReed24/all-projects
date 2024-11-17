package com.thealgorithms.dynamicprogramming;

public final class SubsetSum {
    private SubsetSum() {
    }

    public static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;

        boolean[] isSum = new boolean[sum + 1];

        isSum[0] = true;

        for (int i = 0; i < n; i++) {
            
            for (int j = sum; j >= arr[i]; j--) {
                isSum[j] = isSum[j] || isSum[j - arr[i]];
            }
        }
        return isSum[sum];
    }
}
