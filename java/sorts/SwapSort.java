package com.thealgorithms.sorts;

public class SwapSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int index = 0;

        while (index < array.length - 1) {
            final int amountSmallerElements = this.getSmallerElementCount(array, index);

            if (amountSmallerElements > 0) {
                SortUtils.swap(array, index, index + amountSmallerElements);
            } else {
                index++;
            }
        }

        return array;
    }

    private <T extends Comparable<T>> int getSmallerElementCount(final T[] array, final int index) {
        int counter = 0;
        for (int i = index + 1; i < array.length; i++) {
            if (SortUtils.less(array[i], array[index])) {
                counter++;
            }
        }

        return counter;
    }
}
