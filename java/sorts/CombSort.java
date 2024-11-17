package com.thealgorithms.sorts;

class CombSort implements SortAlgorithm {
    private static final double SHRINK_FACTOR = 1.3;

    private int getNextGap(int gap) {
        gap = (int) (gap / SHRINK_FACTOR);
        return Math.max(gap, 1);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int gap = arr.length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = performSwaps(arr, gap);
        }

        return arr;
    }

    private <T extends Comparable<T>> boolean performSwaps(final T[] arr, final int gap) {
        boolean swapped = false;

        for (int i = 0; i < arr.length - gap; i++) {
            if (SortUtils.less(arr[i + gap], arr[i])) {
                SortUtils.swap(arr, i, i + gap);
                swapped = true;
            }
        }

        return swapped;
    }
}
