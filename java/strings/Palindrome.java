package com.thealgorithms.strings;

final class Palindrome {
    private Palindrome() {
    }

    public static boolean isPalindrome(String s) {
        return ((s == null || s.length() <= 1) || s.equals(new StringBuilder(s).reverse().toString()));
    }

    public static boolean isPalindromeRecursion(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindromeRecursion(s.substring(1, s.length() - 1));
    }

    public static boolean isPalindromeTwoPointer(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
