package com.thealgorithms.misc;

final class Sparsity {
    private Sparsity() {
    }

    static double sparsity(double[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        int zero = 0;
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    zero++;
                }
            }
        }
        
        return ((double) zero / (mat.length * mat[0].length));
    }
}
