package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SortOrderAgnosticBinarySearchTest {

    @Test
    public void testAscending() {
        int[] arr = {1, 2, 3, 4, 5}; 
        int target = 2;
        int ans = SortOrderAgnosticBinarySearch.find(arr, target);
        int excepted = 1;
        assertEquals(excepted, ans);
    }

    @Test
    public void testDescending() {
        int[] arr = {5, 4, 3, 2, 1}; 
        int target = 2;
        int ans = SortOrderAgnosticBinarySearch.find(arr, target);
        int excepted = 3;
        assertEquals(excepted, ans);
    }
}
