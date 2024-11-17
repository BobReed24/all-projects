package com.thealgorithms.conversions;

public final class OctalToDecimal {
    private static final int OCTAL_BASE = 8;

    private OctalToDecimal() {
    }

    public static int convertOctalToDecimal(String inputOctal) {
        if (inputOctal == null || inputOctal.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        int decimalValue = 0;

        for (int i = 0; i < inputOctal.length(); i++) {
            char currentChar = inputOctal.charAt(i);

            if (currentChar < '0' || currentChar > '7') {
                throw new IllegalArgumentException("Incorrect input: Expecting an octal number (digits 0-7)");
            }

            int currentDigit = currentChar - '0';
            decimalValue = decimalValue * OCTAL_BASE + currentDigit;
        }

        return decimalValue;
    }
}
