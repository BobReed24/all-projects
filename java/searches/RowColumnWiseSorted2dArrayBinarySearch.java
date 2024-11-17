package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.MatrixSearchAlgorithm;

public class RowColumnWiseSorted2dArrayBinarySearch implements MatrixSearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int[] find(T[][] matrix, T key) {
        return search(matrix, key);
    }

    public static <T extends Comparable<T>> int[] search(T[][] matrix, T target) {
        int rowPointer = 0; 
        int colPointer = matrix.length - 1; 

        while (rowPointer < matrix.length && colPointer >= 0) {
            int comp = target.compareTo(matrix[rowPointer][colPointer]);

            if (comp == 0) {
                return new int[] {rowPointer, colPointer};
            } else if (comp > 0) {
                rowPointer++; 
            } else {
                colPointer--; 
            }
        }
        return new int[] {-1, -1}; 
    }
}
