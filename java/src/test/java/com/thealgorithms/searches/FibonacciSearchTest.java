package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class FibonacciSearchTest {

    @Test
    void testFibonacciSearchFound() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        int key = 128;
        int expectedIndex = 7; 
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The index of the found element should be 7.");
    }

    @Test
    void testFibonacciSearchNotFound() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1, 2, 4, 8, 16};
        int key = 6; 
        int expectedIndex = -1; 
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testFibonacciSearchFirstElement() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1, 2, 4, 8, 16};
        int key = 1; 
        int expectedIndex = 0; 
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testFibonacciSearchLastElement() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1, 2, 4, 8, 16};
        int key = 16; 
        int expectedIndex = 4; 
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The index of the last element should be 4.");
    }

    @Test
    void testFibonacciSearchSingleElementFound() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1};
        int key = 1; 
        int expectedIndex = 0; 
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The index of the single element should be 0.");
    }

    @Test
    void testFibonacciSearchSingleElementNotFound() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1};
        int key = 2; 
        int expectedIndex = -1; 
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testFibonacciSearchEmptyArray() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {}; 
        int key = 1; 
        assertThrows(IllegalArgumentException.class, () -> fibonacciSearch.find(array, key), "An empty array should throw an IllegalArgumentException.");
    }

    @Test
    void testFibonacciSearchUnsortedArray() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {2, 1, 4, 3, 6, 5};
        int key = 3; 
        assertThrows(IllegalArgumentException.class, () -> fibonacciSearch.find(array, key), "An unsorted array should throw an IllegalArgumentException.");
    }

    @Test
    void testFibonacciSearchNullKey() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = {1, 2, 4, 8, 16};
        Integer key = null; 
        assertThrows(IllegalArgumentException.class, () -> fibonacciSearch.find(array, key), "A null key should throw an IllegalArgumentException.");
    }

    @Test
    void testFibonacciSearchLargeArray() {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        Integer[] array = IntStream.range(0, 10000).boxed().toArray(Integer[] ::new); 
        int key = 9999;
        int expectedIndex = 9999;
        assertEquals(expectedIndex, fibonacciSearch.find(array, key), "The index of the last element should be 9999.");
    }
}
