package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IterativeBinarySearchTest {

    @Test
    void testBinarySearchFound() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        Integer key = 128;
        int expectedIndex = 7; 
        assertEquals(expectedIndex, binarySearch.find(array, key), "The index of the found element should be 7.");
    }

    @Test
    void testBinarySearchNotFound() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {1, 2, 4, 8, 16};
        Integer key = 6; 
        assertEquals(-1, binarySearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testBinarySearchFirstElement() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {1, 2, 4, 8, 16};
        Integer key = 1; 
        assertEquals(0, binarySearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testBinarySearchLastElement() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {1, 2, 4, 8, 16};
        Integer key = 16; 
        assertEquals(4, binarySearch.find(array, key), "The index of the last element should be 4.");
    }

    @Test
    void testBinarySearchSingleElementFound() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {1};
        Integer key = 1; 
        assertEquals(0, binarySearch.find(array, key), "The index of the single element should be 0.");
    }

    @Test
    void testBinarySearchSingleElementNotFound() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {1};
        Integer key = 2; 
        assertEquals(-1, binarySearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testBinarySearchEmptyArray() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = {}; 
        Integer key = 1; 
        assertEquals(-1, binarySearch.find(array, key), "The element should not be found in an empty array.");
    }

    @Test
    void testBinarySearchLargeArray() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = new Integer[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        } 
        Integer key = 9998; 
        assertEquals(4999, binarySearch.find(array, key), "The index of the found element should be 4999.");
    }

    @Test
    void testBinarySearchLargeArrayNotFound() {
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
        Integer[] array = new Integer[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        } 
        Integer key = 9999; 
        assertEquals(-1, binarySearch.find(array, key), "The element should not be found in the array.");
    }
}
