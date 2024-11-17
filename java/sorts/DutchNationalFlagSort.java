package com.thealgorithms.sorts;

public class DutchNationalFlagSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return dutchNationalFlagSort(array, array[(int) Math.ceil((array.length) / 2.0) - 1]);
    }

    public <T extends Comparable<T>> T[] sort(T[] array, T intendedMiddle) {
        return dutchNationalFlagSort(array, intendedMiddle);
    }

    private <T extends Comparable<T>> T[] dutchNationalFlagSort(final T[] array, final T intendedMiddle) {
        int i = 0;
        int j = 0;
        int k = array.length - 1;

        while (j <= k) {
            if (0 > array[j].compareTo(intendedMiddle)) {
                SortUtils.swap(array, i, j);
                j++;
                i++;
            } else if (0 < array[j].compareTo(intendedMiddle)) {
                SortUtils.swap(array, j, k);
                k--;
            } else {
                j++;
            }
        }
        return array;
    }
}
