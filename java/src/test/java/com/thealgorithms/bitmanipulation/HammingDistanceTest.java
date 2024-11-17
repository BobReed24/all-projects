package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HammingDistanceTest {

    @Test
    public void testHammingDistance() {
        assertEquals(3, HammingDistance.hammingDistance(9, 14)); 
        assertEquals(0, HammingDistance.hammingDistance(10, 10)); 
        assertEquals(1, HammingDistance.hammingDistance(1, 0)); 
        assertEquals(2, HammingDistance.hammingDistance(4, 1)); 
        assertEquals(4, HammingDistance.hammingDistance(0, 15)); 
    }
}
