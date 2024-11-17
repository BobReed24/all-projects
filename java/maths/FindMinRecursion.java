package com.thealgorithms.maths;

public final class FindMinRecursion {

    private FindMinRecursion() {
    }

    public static int min(final int[] array, final int low, final int high) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array must be non-empty.");
        }
        if (low == high) {
            return array[low]; 
        }

        int mid = (low + high) >>> 1;

        int leftMin = min(array, low, mid); 
        int rightMin = min(array, mid + 1, high); 

        return Math.min(leftMin, rightMin);
    }

    public static int min(final int[] array) {
        return min(array, 0, array.length - 1);
    }
}
