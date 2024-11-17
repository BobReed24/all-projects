package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountLeadingZerosTest {

    @Test
    public void testCountLeadingZeros() {
        assertEquals(29, CountLeadingZeros.countLeadingZeros(5)); 
        assertEquals(32, CountLeadingZeros.countLeadingZeros(0)); 
        assertEquals(31, CountLeadingZeros.countLeadingZeros(1)); 
        assertEquals(0, CountLeadingZeros.countLeadingZeros(-1)); 
    }
}
