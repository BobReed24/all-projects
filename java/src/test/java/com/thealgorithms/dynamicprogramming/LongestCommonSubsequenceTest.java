package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void testLCSBasic() {
        String str1 = "ABCBDAB";
        String str2 = "BDCAB";
        String expected = "BDAB"; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSIdenticalStrings() {
        String str1 = "AGGTAB";
        String str2 = "AGGTAB";
        String expected = "AGGTAB"; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSNoCommonCharacters() {
        String str1 = "ABC";
        String str2 = "XYZ";
        String expected = ""; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSWithEmptyString() {
        String str1 = "";
        String str2 = "XYZ";
        String expected = ""; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSWithBothEmptyStrings() {
        String str1 = "";
        String str2 = "";
        String expected = ""; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSWithNullFirstString() {
        String str1 = null;
        String str2 = "XYZ";
        String expected = null; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSWithNullSecondString() {
        String str1 = "ABC";
        String str2 = null;
        String expected = null; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSWithNullBothStrings() {
        String str1 = null;
        String str2 = null;
        String expected = null; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }

    @Test
    public void testLCSWithLongerStringContainingCommonSubsequence() {
        String str1 = "ABCDEF";
        String str2 = "AEBDF";
        String expected = "ABDF"; 
        String result = LongestCommonSubsequence.getLCS(str1, str2);
        assertEquals(expected, result);
    }
}
