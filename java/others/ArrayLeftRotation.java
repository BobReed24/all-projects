package com.thealgorithms.others;

public final class ArrayLeftRotation {
    private ArrayLeftRotation() {
    }

    public static int[] rotateLeft(int[] arr, int n) {
        int size = arr.length;

        if (size == 0 || n <= 0) {
            return arr.clone();
        }

        n = n % size;
        if (n == 0) {
            return arr.clone();
        }

        int[] rotated = new int[size];

        for (int i = 0; i < size; i++) {
            rotated[i] = arr[(i + n) % size];
        }

        return rotated;
    }
}
