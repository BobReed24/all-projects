package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class ExponentialSearchTest {

    @Test
    void testExponentialSearchFound() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 7;
        int expectedIndex = 6; 
        assertEquals(expectedIndex, exponentialSearch.find(array, key), "The index of the found element should be 6.");
    }

    @Test
    void testExponentialSearchFirstElement() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        Integer[] array = {1, 2, 3, 4, 5};
        int key = 1; 
        int expectedIndex = 0; 
        assertEquals(expectedIndex, exponentialSearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testExponentialSearchLastElement() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        Integer[] array = {1, 2, 3, 4, 5};
        int key = 5; 
        int expectedIndex = 4; 
        assertEquals(expectedIndex, exponentialSearch.find(array, key), "The index of the last element should be 4.");
    }

    @Test
    void testExponentialSearchSingleElementFound() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        Integer[] array = {1};
        int key = 1; 
        int expectedIndex = 0; 
        assertEquals(expectedIndex, exponentialSearch.find(array, key), "The index of the single element should be 0.");
    }

    @Test
    void testExponentialSearchEmptyArray() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        Integer[] array = {}; 
        int key = 1; 
        int expectedIndex = -1; 
        assertEquals(expectedIndex, exponentialSearch.find(array, key), "The element should not be found in an empty array.");
    }

    @Test
    void testExponentialSearchLargeArray() {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        Integer[] array = IntStream.range(0, 10000).boxed().toArray(Integer[] ::new); 
        int key = 9999;
        int expectedIndex = 9999;
        assertEquals(expectedIndex, exponentialSearch.find(array, key), "The index of the last element should be 9999.");
    }
}
