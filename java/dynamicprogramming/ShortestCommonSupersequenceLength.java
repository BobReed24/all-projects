package com.thealgorithms.dynamicprogramming;

final class ShortestCommonSupersequenceLength {
    private ShortestCommonSupersequenceLength() {
    }

    static int shortestSuperSequence(String x, String y) {
        int m = x.length();
        int n = y.length();

        int l = lcs(x, y, m, n);

        return m + n - l;
    }

    static int lcs(String x, String y, int m, int n) {
        int[][] lN = new int[m + 1][n + 1];
        int i;
        int j;

        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lN[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lN[i][j] = lN[i - 1][j - 1] + 1;
                } else {
                    lN[i][j] = Math.max(lN[i - 1][j], lN[i][j - 1]);
                }
            }
        }

        return lN[m][n];
    }
}
