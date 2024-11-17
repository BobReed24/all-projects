package com.thealgorithms.sorts;

import java.util.Arrays;

public final class CountingSort {
    private CountingSort() {
    }

    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        final var stats = Arrays.stream(array).summaryStatistics();
        final int min = stats.getMin();
        int[] count = computeHistogram(array, min, stats.getMax() - min + 1);
        toCumulative(count);
        return reconstructSorted(count, min, array);
    }

    private static int[] computeHistogram(final int[] array, final int shift, final int spread) {
        int[] res = new int[spread];
        for (final var value : array) {
            res[value - shift]++;
        }
        return res;
    }

    private static void toCumulative(int[] count) {
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    }

    private static int[] reconstructSorted(final int[] cumulativeCount, final int shift, final int[] array) {
        int[] res = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            res[cumulativeCount[array[i] - shift] - 1] = array[i];
            cumulativeCount[array[i] - shift]--;
        }
        return res;
    }
}
