package com.thealgorithms.dynamicprogramming;

public final class MatrixChainRecursiveTopDownMemoisation {
    private MatrixChainRecursiveTopDownMemoisation() {
    }

    static int memoizedMatrixChain(int[] p) {
        int n = p.length;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }
        return lookupChain(m, p, 1, n - 1);
    }

    static int lookupChain(int[][] m, int[] p, int i, int j) {
        if (i == j) {
            m[i][j] = 0;
            return m[i][j];
        }
        if (m[i][j] < Integer.MAX_VALUE) {
            return m[i][j];
        } else {
            for (int k = i; k < j; k++) {
                int q = lookupChain(m, p, i, k) + lookupChain(m, p, k + 1, j) + (p[i - 1] * p[k] * p[j]);
                if (q < m[i][j]) {
                    m[i][j] = q;
                }
            }
        }
        return m[i][j];
    }
}
