package com.thealgorithms.sorts;

public class SelectionSortRecursive implements SortAlgorithm {

    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 0) {
            return array;
        }
        recursiveSelectionSort(array, 0);
        return array;
    }

    private static <T extends Comparable<T>> void recursiveSelectionSort(T[] array, final int index) {
        if (index == array.length - 1) {
            return;
        }

        SortUtils.swap(array, index, findMinIndex(array, index));

        recursiveSelectionSort(array, index + 1);
    }

    private static <T extends Comparable<T>> int findMinIndex(T[] array, final int start) {
        
        if (start == array.length - 1) {
            return start;
        }

        final int minIndexInRest = findMinIndex(array, start + 1);

        return array[start].compareTo(array[minIndexInRest]) < 0 ? start : minIndexInRest;
    }
}
