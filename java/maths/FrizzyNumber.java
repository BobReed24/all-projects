package com.thealgorithms.maths;

public final class FrizzyNumber {
    private FrizzyNumber() {
    }

    public static double getNthFrizzy(int base, int n) {
        double final1 = 0.0;
        int i = 0;
        do {
            final1 += Math.pow(base, i++) * (n % 2);
        } while ((n /= 2) > 0);
        return final1;
    }
}
