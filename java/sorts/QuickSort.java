package com.thealgorithms.sorts;

class QuickSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void doSort(T[] array, final int left, final int right) {
        if (left < right) {
            final int pivot = randomPartition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(T[] array, final int left, final int right) {
        final int randomIndex = left + (int) (Math.random() * (right - left + 1));
        SortUtils.swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        final int mid = (left + right) >>> 1;
        final T pivot = array[mid];

        while (left <= right) {
            while (SortUtils.less(array[left], pivot)) {
                ++left;
            }
            while (SortUtils.less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                SortUtils.swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }
}
