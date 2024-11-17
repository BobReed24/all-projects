package com.thealgorithms.maths;

public final class EulersFunction {
    private EulersFunction() {
    }

    private static void checkInput(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive.");
        }
    }

    public static int getEuler(int n) {
        checkInput(n);
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}
