package com.thealgorithms.maths;

public final class PalindromeNumber {
    private PalindromeNumber() {
    }
    
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Input parameter must not be negative!");
        }
        int numberCopy = number;
        int reverseNumber = 0;
        while (numberCopy != 0) {
            int remainder = numberCopy % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            numberCopy /= 10;
        }
        return number == reverseNumber;
    }
}
