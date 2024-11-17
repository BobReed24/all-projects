package com.thealgorithms.maths;

public final class FindMaxRecursion {

    private FindMaxRecursion() {
    }
    
    public static int max(final int[] array, final int low, final int high) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array must be non-empty.");
        }
        if (low == high) {
            return array[low]; 
        }

        int mid = (low + high) >>> 1;

        int leftMax = max(array, low, mid); 
        int rightMax = max(array, mid + 1, high); 

        return Math.max(leftMax, rightMax);
    }

    public static int max(final int[] array) {
        return max(array, 0, array.length - 1);
    }
}
