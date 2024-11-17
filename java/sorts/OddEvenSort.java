package com.thealgorithms.sorts;

public final class OddEvenSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = performOddSort(array);
            sorted = performEvenSort(array) && sorted;
        }

        return array;
    }

    private <T extends Comparable<T>> boolean performOddSort(T[] array) {
        boolean sorted = true;
        for (int i = 1; i < array.length - 1; i += 2) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                SortUtils.swap(array, i, i + 1);
                sorted = false;
            }
        }
        return sorted;
    }

    private <T extends Comparable<T>> boolean performEvenSort(T[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i += 2) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                SortUtils.swap(array, i, i + 1);
                sorted = false;
            }
        }
        return sorted;
    }
}
