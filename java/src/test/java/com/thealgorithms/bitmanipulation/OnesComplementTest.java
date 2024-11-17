package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OnesComplementTest {

    @Test
    public void testOnesComplementAllZeroes() {

        assertEquals("1111", OnesComplement.onesComplement("0000"));
        assertEquals("111", OnesComplement.onesComplement("000"));
        assertEquals("11", OnesComplement.onesComplement("00"));
        assertEquals("1", OnesComplement.onesComplement("0"));
    }

    @Test
    public void testOnesComplementAllOnes() {
        
        assertEquals("0000", OnesComplement.onesComplement("1111"));
        assertEquals("000", OnesComplement.onesComplement("111"));
        assertEquals("00", OnesComplement.onesComplement("11"));
        assertEquals("0", OnesComplement.onesComplement("1"));
    }

    @Test
    public void testOnesComplementMixedBits() {
        
        assertEquals("1010", OnesComplement.onesComplement("0101"));
        assertEquals("0101", OnesComplement.onesComplement("1010"));
        assertEquals("1100", OnesComplement.onesComplement("0011"));
        assertEquals("0011", OnesComplement.onesComplement("1100"));
        assertEquals("1001", OnesComplement.onesComplement("0110"));
    }

    @Test
    public void testOnesComplementEmptyString() {
        
        assertEquals("", OnesComplement.onesComplement(""));
    }
}
