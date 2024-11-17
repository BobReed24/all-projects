package com.thealgorithms.searches;

public final class SaddlebackSearch {
    private SaddlebackSearch() {
    }

    static int[] find(int[][] arr, int row, int col, int key) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int[] ans = {-1, -1};
        if (row < 0 || col >= arr[row].length) {
            return ans;
        }
        if (arr[row][col] == key) {
            ans[0] = row;
            ans[1] = col;
            return ans;
        } 
        else if (arr[row][col] > key) {
            return find(arr, row - 1, col, key);
        }
        
        return find(arr, row, col + 1, key);
    }
}
