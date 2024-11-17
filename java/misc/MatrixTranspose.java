package com.thealgorithms.misc;

public final class MatrixTranspose {
    private MatrixTranspose() {
    }

    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is empty");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }
}
