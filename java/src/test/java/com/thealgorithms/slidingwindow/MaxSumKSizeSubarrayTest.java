package com.thealgorithms.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaxSumKSizeSubarrayTest {

    @Test
    void testMaxSumKSizeSubarray() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int expectedMaxSum = 9; 
        assertEquals(expectedMaxSum, MaxSumKSizeSubarray.maxSumKSizeSubarray(arr, k));
    }

    @Test
    void testMaxSumKSizeSubarrayWithDifferentValues() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int expectedMaxSum = 9; 
        assertEquals(expectedMaxSum, MaxSumKSizeSubarray.maxSumKSizeSubarray(arr, k));
    }

    @Test
    void testMaxSumKSizeSubarrayWithInsufficientElements() {
        int[] arr = {1, 2};
        int k = 3; 
        int expectedMaxSum = -1; 
        assertEquals(expectedMaxSum, MaxSumKSizeSubarray.maxSumKSizeSubarray(arr, k));
    }

    @Test
    void testMaxSumKSizeSubarrayWithLargeArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 5;
        int expectedMaxSum = 40; 
        assertEquals(expectedMaxSum, MaxSumKSizeSubarray.maxSumKSizeSubarray(arr, k));
    }

    @Test
    void testMaxSumKSizeSubarrayWithNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4, -5};
        int k = 2;
        int expectedMaxSum = -3; 
        assertEquals(expectedMaxSum, MaxSumKSizeSubarray.maxSumKSizeSubarray(arr, k));
    }

    @Test
    void testMaxSumKSizeSubarrayWithKEqualToArrayLength() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        int expectedMaxSum = 15; 
        assertEquals(expectedMaxSum, MaxSumKSizeSubarray.maxSumKSizeSubarray(arr, k));
    }
}
