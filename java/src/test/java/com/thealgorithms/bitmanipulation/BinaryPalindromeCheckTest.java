package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinaryPalindromeCheckTest {

    @Test
    public void testIsBinaryPalindrome() {
        assertTrue(BinaryPalindromeCheck.isBinaryPalindrome(9)); 
        assertFalse(BinaryPalindromeCheck.isBinaryPalindrome(10)); 
        assertTrue(BinaryPalindromeCheck.isBinaryPalindrome(0)); 
        assertTrue(BinaryPalindromeCheck.isBinaryPalindrome(1)); 
        assertFalse(BinaryPalindromeCheck.isBinaryPalindrome(12)); 
    }
}
