package com.thealgorithms.maths;

public final class LucasSeries {
    private LucasSeries() {
    }

    public static int lucasSeries(int n) {
        return n == 1 ? 2 : n == 2 ? 1 : lucasSeries(n - 1) + lucasSeries(n - 2);
    }

    public static int lucasSeriesIteration(int n) {
        int previous = 2;
        int current = 1;
        for (int i = 1; i < n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return previous;
    }
}
