package com.thealgorithms.maths;

public final class PiNilakantha {
    private PiNilakantha() {
    }

    public static void main(String[] args) {
        assert calculatePi(0) == 3.0;
        assert calculatePi(10) > 3.0;
        assert calculatePi(100) < 4.0;

        System.out.println(calculatePi(500));
    }

    public static double calculatePi(int iterations) {
        if (iterations < 0 || iterations > 500) {
            throw new IllegalArgumentException("Please input Integer Number between 0 and 500");
        }

        double pi = 3;
        int divCounter = 2;

        for (int i = 0; i < iterations; i++) {
            if (i % 2 == 0) {
                pi = pi + 4.0 / (divCounter * (divCounter + 1) * (divCounter + 2));
            } else {
                pi = pi - 4.0 / (divCounter * (divCounter + 1) * (divCounter + 2));
            }

            divCounter += 2;
        }
        return pi;
    }
}
