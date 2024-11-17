package com.thealgorithms.maths;

public final class JosephusProblem {
    private JosephusProblem() {
    }

    public static int findTheWinner(int n, int k) {
        return winner(n, k) + 1;
    }

    public static int winner(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (winner(n - 1, k) + k) % n;
    }
}
