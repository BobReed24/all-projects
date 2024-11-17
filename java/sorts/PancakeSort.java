package com.thealgorithms.sorts;

public class PancakeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length < 2) {
            return array;
        }

        for (int currentSize = 0; currentSize < array.length; currentSize++) {
            int maxIndex = findMaxIndex(array, currentSize);
            SortUtils.flip(array, maxIndex, array.length - 1 - currentSize);
        }

        return array;
    }

    private <T extends Comparable<T>> int findMaxIndex(T[] array, int currentSize) {
        T max = array[0];
        int maxIndex = 0;
        for (int i = 0; i < array.length - currentSize; i++) {
            if (SortUtils.less(max, array[i])) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
