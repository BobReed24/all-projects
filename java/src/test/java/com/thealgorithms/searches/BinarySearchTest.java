package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void testBinarySearchFound() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 7;
        int expectedIndex = 6; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the found element should be 6.");
    }

    @Test
    void testBinarySearchNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {1, 2, 3, 4, 5};
        int key = 6; 
        int expectedIndex = -1; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testBinarySearchFirstElement() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {1, 2, 3, 4, 5};
        int key = 1; 
        int expectedIndex = 0; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testBinarySearchLastElement() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {1, 2, 3, 4, 5};
        int key = 5; 
        int expectedIndex = 4; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the last element should be 4.");
    }

    @Test
    void testBinarySearchSingleElementFound() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {1};
        int key = 1; 
        int expectedIndex = 0; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the single element should be 0.");
    }

    @Test
    void testBinarySearchSingleElementNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {1};
        int key = 2; 
        int expectedIndex = -1; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = {}; 
        int key = 1; 
        int expectedIndex = -1; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The element should not be found in an empty array.");
    }

    @Test
    void testBinarySearchLargeArray() {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = IntStream.range(0, 10000).boxed().toArray(Integer[] ::new); 
        int key = 9999; 
        int expectedIndex = 9999; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the last element should be 9999.");
    }
}
