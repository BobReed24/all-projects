package com.thealgorithms.dynamicprogramming;

public final class CountFriendsPairing {
    private CountFriendsPairing() {
    }

    public static boolean countFriendsPairing(int n, int[] a) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            dp[i] = 1 + dp[i - dp[dp[i - 1]]];
            
        }
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != dp[i]) {
                return false;
                
            }
        }
        return true;
        
    }
}
