package com.thealgorithms.searches;

public final class OrderAgnosticBinarySearch {
    private OrderAgnosticBinarySearch() {
    }

    static int binSearchAlgo(int[] arr, int start, int end, int target) {

        boolean ascOrd = arr[start] < arr[end];

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] == target) {
                return middle; 
            }
            if (ascOrd) {
                
                if (arr[middle] < target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                
                if (arr[middle] > target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        
        return -1;
    }
}
