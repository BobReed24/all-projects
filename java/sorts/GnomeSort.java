package com.thealgorithms.sorts;

public class GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(final T[] array) {
        int i = 1;
        int j = 2;
        while (i < array.length) {
            if (SortUtils.less(array[i - 1], array[i])) {
                i = j++;
            } else {
                SortUtils.swap(array, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }

        return array;
    }
}
