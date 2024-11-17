package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HigherLowerPowerOfTwoTest {

    @Test
    public void testNextHigherPowerOfTwo() {
        assertEquals(32, HigherLowerPowerOfTwo.nextHigherPowerOfTwo(19)); 
        assertEquals(1, HigherLowerPowerOfTwo.nextHigherPowerOfTwo(1)); 
        assertEquals(16, HigherLowerPowerOfTwo.nextHigherPowerOfTwo(15)); 
        assertEquals(8, HigherLowerPowerOfTwo.nextHigherPowerOfTwo(8)); 
        assertEquals(16, HigherLowerPowerOfTwo.nextHigherPowerOfTwo(9)); 
    }

    @Test
    public void testNextLowerPowerOfTwo() {
        assertEquals(16, HigherLowerPowerOfTwo.nextLowerPowerOfTwo(19)); 
        assertEquals(1, HigherLowerPowerOfTwo.nextLowerPowerOfTwo(1)); 
        assertEquals(8, HigherLowerPowerOfTwo.nextLowerPowerOfTwo(9)); 
        assertEquals(8, HigherLowerPowerOfTwo.nextLowerPowerOfTwo(15)); 
        assertEquals(8, HigherLowerPowerOfTwo.nextLowerPowerOfTwo(8)); 
    }
}
