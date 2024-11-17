package com.thealgorithms.backtracking;

import java.util.LinkedList;
import java.util.List;

public final class Permutation {
    private Permutation() {
    }

    public static <T> List<T[]> permutation(T[] arr) {
        T[] array = arr.clone();
        List<T[]> result = new LinkedList<>();
        backtracking(array, 0, result);
        return result;
    }

    private static <T> void backtracking(T[] arr, int index, List<T[]> result) {
        if (index == arr.length) {
            result.add(arr.clone());
        }
        for (int i = index; i < arr.length; i++) {
            swap(index, i, arr);
            backtracking(arr, index + 1, result);
            swap(index, i, arr);
        }
    }

    private static <T> void swap(int a, int b, T[] arr) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
