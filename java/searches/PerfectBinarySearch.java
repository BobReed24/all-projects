package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;

public class PerfectBinarySearch<T> implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        return search(array, key, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
        while (left <= right) {
            int median = (left + right) >>> 1;
            int comp = key.compareTo(array[median]);

            if (comp == 0) {
                return median; 
            }

            if (comp < 0) {
                right = median - 1; 
            } else {
                left = median + 1; 
            }
        }
        return -1; 
    }
}
