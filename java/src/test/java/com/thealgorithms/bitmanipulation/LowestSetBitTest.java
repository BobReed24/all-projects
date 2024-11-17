package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LowestSetBitTest {

    @Test
    void testLowestSetBitWithPositiveNumber() {
        
        assertEquals(2, LowestSetBit.isolateLowestSetBit(18)); 
    }

    @Test
    void testLowestSetBitWithZero() {
        
        assertEquals(0, LowestSetBit.isolateLowestSetBit(0)); 
    }

    @Test
    void testLowestSetBitWithOne() {
        
        assertEquals(1, LowestSetBit.isolateLowestSetBit(1)); 
    }

    @Test
    void testLowestSetBitWithPowerOfTwo() {
        
        assertEquals(16, LowestSetBit.isolateLowestSetBit(16)); 
    }

    @Test
    void testLowestSetBitWithAllBitsSet() {
        
        assertEquals(1, LowestSetBit.isolateLowestSetBit(7)); 
    }

    @Test
    void testLowestSetBitWithNegativeNumber() {
        
        assertEquals(1, LowestSetBit.isolateLowestSetBit(-1)); 
    }

    @Test
    void testLowestSetBitWithLargeNumber() {
        
        assertEquals(64, LowestSetBit.isolateLowestSetBit(448)); 
    }

    @Test
    void testClearLowestSetBitFor18() {
        
        assertEquals(16, LowestSetBit.clearLowestSetBit(18));
    }

    @Test
    void testClearLowestSetBitFor10() {
        
        assertEquals(8, LowestSetBit.clearLowestSetBit(10));
    }

    @Test
    void testClearLowestSetBitFor7() {
        
        assertEquals(6, LowestSetBit.clearLowestSetBit(7));
    }

    @Test
    void testClearLowestSetBitFor0() {
        
        assertEquals(0, LowestSetBit.clearLowestSetBit(0));
    }

    @Test
    void testClearLowestSetBitForNegativeNumber() {
        
        assertEquals(-2, LowestSetBit.clearLowestSetBit(-1));
    }
}
