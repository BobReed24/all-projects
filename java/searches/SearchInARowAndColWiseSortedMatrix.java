package com.thealgorithms.searches;

public class SearchInARowAndColWiseSortedMatrix {
    
    public int[] search(int[][] matrix, int value) {
        int n = matrix.length;
        
        int i = 0;
        
        int j = n - 1;
        int[] result = {-1, -1};

        while (i < n && j >= 0) {
            if (matrix[i][j] == value) {
                result[0] = i;
                result[1] = j;
                return result;
            }
            if (value > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
