package com.thealgorithms.dynamicprogramming;

public final class SubsetSumSpaceOptimized {
    private SubsetSumSpaceOptimized() {
    }
    
    public static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        return dp[sum];
    }
}
