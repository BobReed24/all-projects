package com.thealgorithms.conversions;

final class BinaryToDecimal {
    private static final int BINARY_BASE = 2;

    private BinaryToDecimal() {
    }

    public static long binaryToDecimal(long binaryNumber) {
        long decimalValue = 0;
        long power = 0;

        while (binaryNumber != 0) {
            long digit = binaryNumber % 10;
            if (digit > 1) {
                throw new IllegalArgumentException("Incorrect binary digit: " + digit);
            }
            decimalValue += (long) (digit * Math.pow(BINARY_BASE, power++));
            binaryNumber /= 10;
        }
        return decimalValue;
    }
}
