package com.thealgorithms.bitmanipulation;

public final class BinaryPalindromeCheck {
    private BinaryPalindromeCheck() {
    }

    public static boolean isBinaryPalindrome(int x) {
        int reversed = reverseBits(x);
        return x == reversed;
    }

    private static int reverseBits(int x) {
        int result = 0;
        while (x > 0) {
            result <<= 1;
            result |= (x & 1);
            x >>= 1;
        }
        return result;
    }
}
