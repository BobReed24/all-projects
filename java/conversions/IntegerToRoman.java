package com.thealgorithms.conversions;

public final class IntegerToRoman {

    private static final int[] ALL_ROMAN_NUMBERS_IN_ARABIC = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static final String[] ALL_ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private IntegerToRoman() {
    }

    public static String integerToRoman(int num) {
        if (num <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ALL_ROMAN_NUMBERS_IN_ARABIC.length; i++) {
            int times = num / ALL_ROMAN_NUMBERS_IN_ARABIC[i];
            builder.append(ALL_ROMAN_NUMBERS[i].repeat(Math.max(0, times)));
            num -= times * ALL_ROMAN_NUMBERS_IN_ARABIC[i];
        }

        return builder.toString();
    }
}
