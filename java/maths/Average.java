package com.thealgorithms.maths;

public final class Average {

    private Average() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    public static double average(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty or null");
        }
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static double average(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty or null");
        }
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) (sum / numbers.length);
    }
}
