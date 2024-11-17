package com.thealgorithms.sorts;

public class ShellSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 0) {
            return array;
        }

        int gap = calculateInitialGap(array.length);

        while (gap > 0) {
            performGapInsertionSort(array, gap);
            gap = calculateNextGap(gap);
        }

        return array;
    }

    private int calculateInitialGap(final int length) {
        int gap = 1;
        while (gap < length / 3) {
            gap = 3 * gap + 1;
        }
        return gap;
    }

    private int calculateNextGap(final int currentGap) {
        return currentGap / 3;
    }

    private <T extends Comparable<T>> void performGapInsertionSort(final T[] array, final int gap) {
        for (int i = gap; i < array.length; i++) {
            T temp = array[i];
            int j;
            for (j = i; j >= gap && SortUtils.less(temp, array[j - gap]); j -= gap) {
                array[j] = array[j - gap];
            }
            array[j] = temp;
        }
    }
}
