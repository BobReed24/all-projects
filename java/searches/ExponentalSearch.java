package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;
import java.util.Arrays;

class ExponentialSearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        if (array.length == 0) {
            return -1;
        }
        if (array[0].equals(key)) {
            return 0;
        }
        if (array[array.length - 1].equals(key)) {
            return array.length - 1;
        }

        int range = 1;
        while (range < array.length && array[range].compareTo(key) < 0) {
            range = range * 2;
        }

        return Arrays.binarySearch(array, range / 2, Math.min(range, array.length), key);
    }
}
