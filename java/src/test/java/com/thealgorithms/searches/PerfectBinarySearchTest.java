package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PerfectBinarySearchTest {

    @Test
    public void testIntegerBinarySearch() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        PerfectBinarySearch<Integer> binarySearch = new PerfectBinarySearch<>();

        assertEquals(0, binarySearch.find(array, 1)); 
        assertEquals(4, binarySearch.find(array, 5)); 
        assertEquals(9, binarySearch.find(array, 10)); 
        assertEquals(6, binarySearch.find(array, 7)); 

        assertEquals(-1, binarySearch.find(array, 0)); 
        assertEquals(-1, binarySearch.find(array, 11)); 
        assertEquals(-1, binarySearch.find(array, 100)); 
    }

    @Test
    public void testStringBinarySearch() {
        String[] array = {"apple", "banana", "cherry", "date", "fig"};
        PerfectBinarySearch<String> binarySearch = new PerfectBinarySearch<>();

        assertEquals(-1, binarySearch.find(array, "apricot")); 
        assertEquals(-1, binarySearch.find(array, "bananaa")); 

        assertEquals(0, binarySearch.find(array, "apple")); 
        assertEquals(2, binarySearch.find(array, "cherry")); 
        assertEquals(4, binarySearch.find(array, "fig")); 
    }
}
