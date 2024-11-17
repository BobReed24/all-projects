package com.thealgorithms.misc;

public final class MirrorOfMatrix {
    private MirrorOfMatrix() {
    }

    public static int[][] mirrorMatrix(final int[][] originalMatrix) {
        if (originalMatrix == null) {
            
            return null;
        }
        if (originalMatrix.length == 0) {
            return new int[0][0];
        }

        checkInput(originalMatrix);

        int numRows = originalMatrix.length;
        int numCols = originalMatrix[0].length;

        int[][] mirroredMatrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            mirroredMatrix[i] = reverseRow(originalMatrix[i]);
        }
        return mirroredMatrix;
    }
    private static int[] reverseRow(final int[] inRow) {
        int[] res = new int[inRow.length];
        for (int i = 0; i < inRow.length; ++i) {
            res[i] = inRow[inRow.length - 1 - i];
        }
        return res;
    }

    private static void checkInput(final int[][] matrix) {
        
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != matrix[0].length) {
                throw new IllegalArgumentException("The input is not a matrix.");
            }
        }
    }
}
