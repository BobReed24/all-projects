package com.thealgorithms.sorts;

class ExchangeSort implements SortAlgorithm {
    
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    SortUtils.swap(array, i, j);
                }
            }
        }
        return array;
    }
}
