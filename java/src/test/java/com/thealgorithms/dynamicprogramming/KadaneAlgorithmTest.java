package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class KadaneAlgorithmTest {

    @Test
    void testMaxSumWithPositiveValues() {
        
        int[] input = {89, 56, 98, 123, 26, 75, 12, 40, 39, 68, 91};
        int expectedMaxSum = 89 + 56 + 98 + 123 + 26 + 75 + 12 + 40 + 39 + 68 + 91; 
        assertTrue(KadaneAlgorithm.maxSum(input, expectedMaxSum));
    }

    @Test
    void testMaxSumWithMixedValues() {
        
        int[] input = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        int expectedMaxSum = 3 + 4 + -1 + 2 + 1; 
        assertTrue(KadaneAlgorithm.maxSum(input, expectedMaxSum));
    }

    @Test
    void testMaxSumWithAllNegativeValues() {
        
        int[] input = {-2, -3, -1, -4};
        int expectedMaxSum = -1; 
        assertTrue(KadaneAlgorithm.maxSum(input, expectedMaxSum));
    }

    @Test
    void testMaxSumWithSingleElement() {
        
        int[] input = {10};
        int expectedMaxSum = 10; 
        assertTrue(KadaneAlgorithm.maxSum(input, expectedMaxSum));

        input = new int[] {-10};
        expectedMaxSum = -10; 
        assertTrue(KadaneAlgorithm.maxSum(input, expectedMaxSum));
    }

    @Test
    void testMaxSumWithZero() {
        
        int[] input = {0, -1, 2, -2, 0, 3};
        int expectedMaxSum = 3; 
        assertTrue(KadaneAlgorithm.maxSum(input, expectedMaxSum));
    }

    @Test
    void testMaxSumWithEmptyArray() {
        
        int[] input = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> { KadaneAlgorithm.maxSum(input, 0); });
    }
}
