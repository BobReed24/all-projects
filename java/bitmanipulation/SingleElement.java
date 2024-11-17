package com.thealgorithms.bitmanipulation;

public final class SingleElement {

    private SingleElement() {
        throw new UnsupportedOperationException("Utility Class");
    }

    public static int findSingleElement(int[] arr) {
        int ele = 0;
        for (int i = 0; i < arr.length; i++) {
            ele ^= arr[i];
        }
        return ele;
    }
}
