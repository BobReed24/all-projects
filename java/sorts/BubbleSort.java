package com.thealgorithms.sorts;

class BubbleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (SortUtils.greater(array[j], array[j + 1])) {
                    SortUtils.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
