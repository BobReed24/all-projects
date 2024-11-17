package com.thealgorithms.dynamicprogramming;

public final class Abbreviation {
    private Abbreviation() {
    }

    public static boolean abbr(String a, String b) {
        int n = a.length();
        int m = b.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i][j]) {
                    
                    if (j < m && Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                        dp[i + 1][j + 1] = true;
                    }
                    
                    if (Character.isLowerCase(a.charAt(i))) {
                        dp[i + 1][j] = true;
                    }
                }
            }
        }

        return dp[n][m];
    }
}
