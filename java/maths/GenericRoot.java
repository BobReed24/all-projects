package com.thealgorithms.maths;

public final class GenericRoot {
    private GenericRoot() {
    }

    private static int base = 10;

    private static int sumOfDigits(final int n) {
        assert n >= 0;
        if (n < base) {
            return n;
        }
        return n % base + sumOfDigits(n / base);
    }

    public static int genericRoot(final int n) {
        if (n < 0) {
            return genericRoot(-n);
        }
        if (n > base) {
            return genericRoot(sumOfDigits(n));
        }
        return n;
    }
}
