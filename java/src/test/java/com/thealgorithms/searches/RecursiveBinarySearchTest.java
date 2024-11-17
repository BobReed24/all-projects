package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test; 

public class RecursiveBinarySearchTest {

    @Test
    public void testBinarySearch() {
        
        RecursiveBinarySearch<Integer> searcher = new RecursiveBinarySearch<>();

        Integer[] arr1 = {1, 2, 3, 4, 5};
        int target1 = 3;
        int result1 = searcher.binsear(arr1, 0, arr1.length - 1, target1);
        assertEquals(2, result1);

        Integer[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 6;
        int result2 = searcher.binsear(arr2, 0, arr2.length - 1, target2);
        assertEquals(-1, result2);

        Integer[] arr3 = {10, 20, 30, 40, 50};
        int target3 = 10;
        int result3 = searcher.binsear(arr3, 0, arr3.length - 1, target3);
        assertEquals(0, result3);

        Integer[] arr4 = {10, 20, 30, 40, 50};
        int target4 = 50;
        int result4 = searcher.binsear(arr4, 0, arr4.length - 1, target4);
        assertEquals(4, result4);
    }
}
