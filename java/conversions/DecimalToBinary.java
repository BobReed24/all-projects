package com.thealgorithms.conversions;

final class DecimalToBinary {
    private static final int BINARY_BASE = 2;
    private static final int DECIMAL_MULTIPLIER = 10;

    private DecimalToBinary() {
    }

    public static int convertUsingConventionalAlgorithm(int decimalNumber) {
        int binaryNumber = 0;
        int position = 1;

        while (decimalNumber > 0) {
            int remainder = decimalNumber % BINARY_BASE;
            binaryNumber += remainder * position;
            position *= DECIMAL_MULTIPLIER;
            decimalNumber /= BINARY_BASE;
        }

        return binaryNumber;
    }

    public static int convertUsingBitwiseAlgorithm(int decimalNumber) {
        int binaryNumber = 0;
        int position = 1;

        while (decimalNumber > 0) {
            int leastSignificantBit = decimalNumber & 1;
            binaryNumber += leastSignificantBit * position;
            position *= DECIMAL_MULTIPLIER;
            decimalNumber >>= 1;
        }
        return binaryNumber;
    }
}
