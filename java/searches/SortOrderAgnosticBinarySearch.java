package com.thealgorithms.searches;
public final class SortOrderAgnosticBinarySearch {
    private SortOrderAgnosticBinarySearch() {
    }
    public static int find(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        boolean arrDescending = arr[start] > arr[end]; 
        while (start <= end) {
            int mid = end - start / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arrDescending) { 
                if (key < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { 
                if (key > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
