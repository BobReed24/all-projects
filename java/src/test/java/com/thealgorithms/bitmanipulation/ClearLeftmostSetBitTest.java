package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClearLeftmostSetBitTest {

    @Test
    public void testClearLeftmostSetBit() {
        assertEquals(10, ClearLeftmostSetBit.clearLeftmostSetBit(26)); 
        assertEquals(0, ClearLeftmostSetBit.clearLeftmostSetBit(1)); 
        assertEquals(3, ClearLeftmostSetBit.clearLeftmostSetBit(7)); 
        assertEquals(2, ClearLeftmostSetBit.clearLeftmostSetBit(6)); 
    }
}
