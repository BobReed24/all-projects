package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TwosComplementTest {

    @Test
    public void testTwosComplementAllZeroes() {
        assertEquals("10000", TwosComplement.twosComplement("0000"));
        assertEquals("1000", TwosComplement.twosComplement("000"));
        assertEquals("100", TwosComplement.twosComplement("00"));
        assertEquals("10", TwosComplement.twosComplement("0"));
    }

    @Test
    public void testTwosComplementAllOnes() {
        assertEquals("00001", TwosComplement.twosComplement("11111"));
        assertEquals("0001", TwosComplement.twosComplement("1111"));
        assertEquals("001", TwosComplement.twosComplement("111"));
        assertEquals("01", TwosComplement.twosComplement("11"));
    }

    @Test
    public void testTwosComplementMixedBits() {
        assertEquals("1111", TwosComplement.twosComplement("0001")); 
        assertEquals("1001", TwosComplement.twosComplement("0111")); 
        assertEquals("11001", TwosComplement.twosComplement("00111")); 
        assertEquals("011", TwosComplement.twosComplement("101")); 
    }

    @Test
    public void testTwosComplementSingleBit() {
        assertEquals("10", TwosComplement.twosComplement("0")); 
        assertEquals("1", TwosComplement.twosComplement("1")); 
    }

    @Test
    public void testTwosComplementWithLeadingZeroes() {
        assertEquals("1111", TwosComplement.twosComplement("0001")); 
        assertEquals("101", TwosComplement.twosComplement("011")); 
        assertEquals("110", TwosComplement.twosComplement("010")); 
    }

    @Test
    public void testInvalidBinaryInput() {
        
        assertThrows(IllegalArgumentException.class, () -> TwosComplement.twosComplement("102"));
        assertThrows(IllegalArgumentException.class, () -> TwosComplement.twosComplement("abc"));
        assertThrows(IllegalArgumentException.class, () -> TwosComplement.twosComplement("10a01"));
    }

    @Test
    public void testEmptyInput() {
        
        assertThrows(IllegalArgumentException.class, () -> TwosComplement.twosComplement(""));
    }
}
