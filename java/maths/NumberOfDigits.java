package com.thealgorithms.maths;

public final class NumberOfDigits {
    private NumberOfDigits() {
    }
    
    public static int numberOfDigits(int number) {
        int digits = 0;
        do {
            digits++;
            number /= 10;
        } while (number != 0);
        return digits;
    }

    public static int numberOfDigitsFast(int number) {
        return number == 0 ? 1 : (int) Math.floor(Math.log10(Math.abs(number)) + 1);
    }

    public static int numberOfDigitsFaster(int number) {
        return number < 0 ? (-number + "").length() : (number + "").length();
    }

    public static int numberOfDigitsRecursion(int number) {
        return number / 10 == 0 ? 1 : 1 + numberOfDigitsRecursion(number / 10);
    }
}
