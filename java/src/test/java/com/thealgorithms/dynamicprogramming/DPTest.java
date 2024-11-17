package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DPTest {

    @Test
    void testSumLessThanMinimumFaceValue() {
        
        assertEquals(0, DP.findWays(4, 2, 1)); 
    }

    @Test
    void testTwoDiceWithSumEqualToTwo() {
        
        assertEquals(1, DP.findWays(2, 2, 2)); 
    }

    @Test
    void testTwoDiceWithSumThree() {
        
        assertEquals(2, DP.findWays(2, 2, 3)); 
    }

    @Test
    void testThreeDiceWithSumEight() {
        
        assertEquals(21, DP.findWays(6, 3, 8)); 
    }

    @Test
    void testTwoDiceWithSumFive() {
        
        assertEquals(4, DP.findWays(4, 2, 5)); 
    }

    @Test
    void testThreeDiceWithSumFive() {
        
        assertEquals(6, DP.findWays(4, 3, 5)); 
    }

    @Test
    void testEdgeCaseZeroSum() {
        
        assertEquals(0, DP.findWays(4, 0, 0)); 
    }
}
