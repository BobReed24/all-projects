package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;

public class TernarySearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] arr, T value) {
        return ternarySearch(arr, value, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> int ternarySearch(T[] arr, T key, int start, int end) {
        if (start > end) {
            return -1;
        }
        
        int mid1 = start + (end - start) / 3;
        
        int mid2 = start + 2 * (end - start) / 3;

        if (key.compareTo(arr[mid1]) == 0) {
            return mid1;
        } else if (key.compareTo(arr[mid2]) == 0) {
            return mid2;
        }  else if (key.compareTo(arr[mid1]) < 0) {
            return ternarySearch(arr, key, start, --mid1);
        }  else if (key.compareTo(arr[mid2]) > 0) {
            return ternarySearch(arr, key, ++mid2, end);
        }  else {
            return ternarySearch(arr, key, mid1, mid2);
        }
    }
}
