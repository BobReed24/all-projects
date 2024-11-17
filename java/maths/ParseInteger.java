package com.thealgorithms.maths;

public final class ParseInteger {
    private ParseInteger() {
    }

    private static void checkInput(final String s) {
        if (s == null) {
            throw new NumberFormatException("Input parameter must not be null!");
        }
        if (s.isEmpty()) {
            throw new NumberFormatException("Input parameter must not be empty!");
        }
    }

    private static void checkDigitAt(final String s, final int pos) {
        if (!Character.isDigit(s.charAt(pos))) {
            throw new NumberFormatException("Input parameter of incorrect format: " + s);
        }
    }

    private static int digitToInt(final char digit) {
        return digit - '0';
    }

    public static int parseInt(final String s) {
        checkInput(s);

        final boolean isNegative = s.charAt(0) == '-';
        final boolean isPositive = s.charAt(0) == '+';
        int number = 0;
        for (int i = isNegative || isPositive ? 1 : 0, length = s.length(); i < length; ++i) {
            checkDigitAt(s, i);
            number = number * 10 + digitToInt(s.charAt(i));
        }
        return isNegative ? -number : number;
    }
}
