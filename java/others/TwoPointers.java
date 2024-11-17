package com.thealgorithms.others;

final class TwoPointers {
    private TwoPointers() {
    }

    public static boolean isPairedSum(int[] arr, int key) {
        int i = 0; 
        int j = arr.length - 1; 

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == key) {
                return true;
            } else if (sum < key) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
