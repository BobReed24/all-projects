package com.thealgorithms.bitmanipulation;

public final class BcdConversion {
    private BcdConversion() {
    }

    public static int bcdToDecimal(int bcd) {
        int decimal = 0;
        int multiplier = 1;

        while (bcd > 0) {
            int digit = bcd & 0xF;
            if (digit > 9) {
                throw new IllegalArgumentException("Invalid BCD digit: " + digit);
            }
            decimal += digit * multiplier;
            multiplier *= 10;
            bcd >>= 4;
        }
        return decimal;
    }

    public static int decimalToBcd(int decimal) {
        if (decimal < 0 || decimal > 9999) {
            throw new IllegalArgumentException("Value out of bounds for BCD representation: " + decimal);
        }

        int bcd = 0;
        int shift = 0;
        while (decimal > 0) {
            int digit = decimal % 10;
            bcd |= (digit << (shift * 4));
            decimal /= 10;
            shift++;
        }
        return bcd;
    }
}
