package com.thealgorithms.dynamicprogramming;

public final class MinimumPathSum {

    private MinimumPathSum() {
    }

    public static int minimumPathSum(final int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (numCols == 0) {
            return 0;
        }

        int[] dp = new int[numCols];

        dp[0] = grid[0][0];

        for (int col = 1; col < numCols; col++) {
            dp[col] = dp[col - 1] + grid[0][col];
        }

        for (int row = 1; row < numRows; row++) {
            
            dp[0] += grid[row][0];

            for (int col = 1; col < numCols; col++) {
                
                dp[col] = Math.min(dp[col - 1], dp[col]) + grid[row][col];
            }
        }

        return dp[numCols - 1];
    }
}
