package com.thealgorithms.dynamicprogramming;

public final class LongestAlternatingSubsequence {
    private LongestAlternatingSubsequence() {
    }

    static int alternatingLength(int[] arr, int n) {
        int[][] las = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            las[i][0] = 1;
            las[i][1] = 1;
        }

        int result = 1; 

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                
                if (arr[j] < arr[i] && las[i][0] < las[j][1] + 1) {
                    las[i][0] = las[j][1] + 1;
                }

                if (arr[j] > arr[i] && las[i][1] < las[j][0] + 1) {
                    las[i][1] = las[j][0] + 1;
                }
            }

            result = Math.max(result, Math.max(las[i][0], las[i][1]));
        }

        return result;
    }
}
