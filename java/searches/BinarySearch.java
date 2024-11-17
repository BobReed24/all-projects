package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;

class BinarySearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        return search(array, key, 0, array.length - 1);
    }

    private <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
        if (right < left) {
            return -1; 
        }
        
        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);

        if (comp == 0) {
            return median;
        } else if (comp < 0) {
            return search(array, key, left, median - 1);
        } else {
            return search(array, key, median + 1, right);
        }
    }
}
