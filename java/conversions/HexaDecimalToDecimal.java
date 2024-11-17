package com.thealgorithms.conversions;

public final class HexaDecimalToDecimal {
    private HexaDecimalToDecimal() {
    }

    public static int getHexaToDec(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;

        for (int i = 0; i < hex.length(); i++) {
            int d = digits.indexOf(hex.charAt(i));
            if (d == -1) {
                throw new IllegalArgumentException("Invalid hexadecimal character: " + hex.charAt(i));
            }
            val = 16 * val + d;
        }

        return val;
    }
}
