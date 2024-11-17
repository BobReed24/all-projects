package com.thealgorithms.maths;

public final class SumOfDigits {
    private SumOfDigits() {
    }

    public static int sumOfDigits(int number) {
        final int base = 10;
        number = Math.abs(number);
        int sum = 0;
        while (number != 0) {
            sum += number % base;
            number /= base;
        }
        return sum;
    }

    public static int sumOfDigitsRecursion(int number) {
        final int base = 10;
        number = Math.abs(number);
        return number < base ? number : number % base + sumOfDigitsRecursion(number / base);
    }

    public static int sumOfDigitsFast(final int number) {
        return String.valueOf(Math.abs(number)).chars().map(c -> c - '0').reduce(0, Integer::sum);
    }
}
