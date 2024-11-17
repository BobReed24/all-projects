package com.thealgorithms.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MinSumKSizeSubarrayTest {

    @Test
    void testMinSumKSizeSubarray() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int expectedMinSum = 6; 
        assertEquals(expectedMinSum, MinSumKSizeSubarray.minSumKSizeSubarray(arr, k));
    }

    @Test
    void testMinSumKSizeSubarrayWithDifferentValues() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int expectedMinSum = 3; 
        assertEquals(expectedMinSum, MinSumKSizeSubarray.minSumKSizeSubarray(arr, k));
    }

    @Test
    void testMinSumKSizeSubarrayWithInsufficientElements() {
        int[] arr = {1, 2};
        int k = 3; 
        int expectedMinSum = -1; 
        assertEquals(expectedMinSum, MinSumKSizeSubarray.minSumKSizeSubarray(arr, k));
    }

    @Test
    void testMinSumKSizeSubarrayWithLargeArray() {
        int[] arr = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4};
        int k = 5;
        int expectedMinSum = -10; 
        assertEquals(expectedMinSum, MinSumKSizeSubarray.minSumKSizeSubarray(arr, k));
    }

    @Test
    void testMinSumKSizeSubarrayWithNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4, -5};
        int k = 2;
        int expectedMinSum = -9; 
        assertEquals(expectedMinSum, MinSumKSizeSubarray.minSumKSizeSubarray(arr, k));
    }

    @Test
    void testMinSumKSizeSubarrayWithKEqualToArrayLength() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        int expectedMinSum = 15; 
        assertEquals(expectedMinSum, MinSumKSizeSubarray.minSumKSizeSubarray(arr, k));
    }
}
