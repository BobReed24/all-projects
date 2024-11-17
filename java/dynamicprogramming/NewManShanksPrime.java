package com.thealgorithms.dynamicprogramming;

public final class NewManShanksPrime {
    private NewManShanksPrime() {
    }

    public static boolean nthManShanksPrime(int n, int expectedAnswer) {
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = 2 * a[i - 1] + a[i - 2];
        }

        return a[n] == expectedAnswer;
    }
}
