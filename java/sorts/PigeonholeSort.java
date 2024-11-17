package com.thealgorithms.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PigeonholeSort {
    private PigeonholeSort() {
    }

    public static int[] sort(int[] array) {

        checkForNegativeInput(array);

        if (array.length == 0) {
            return array;
        }

        final int maxElement = Arrays.stream(array).max().orElseThrow();
        final List<List<Integer>> pigeonHoles = createPigeonHoles(maxElement);

        populatePigeonHoles(array, pigeonHoles);
        collectFromPigeonHoles(array, pigeonHoles);

        return array;
    }

    private static void checkForNegativeInput(int[] array) {
        for (final int number : array) {
            if (number < 0) {
                throw new IllegalArgumentException("Array contains negative integers.");
            }
        }
    }

    private static List<List<Integer>> createPigeonHoles(int maxElement) {
        List<List<Integer>> pigeonHoles = new ArrayList<>(maxElement + 1);
        for (int i = 0; i <= maxElement; i++) {
            pigeonHoles.add(new ArrayList<>());
        }
        return pigeonHoles;
    }

    private static void populatePigeonHoles(int[] array, List<List<Integer>> pigeonHoles) {
        for (int element : array) {
            pigeonHoles.get(element).add(element);
        }
    }

    private static void collectFromPigeonHoles(int[] array, Iterable<List<Integer>> pigeonHoles) {
        int index = 0;
        for (final var pigeonHole : pigeonHoles) {
            for (final int element : pigeonHole) {
                array[index++] = element;
            }
        }
    }
}
