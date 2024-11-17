package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

class LinearSearchTest {

    @Test
    void testLinearSearchFound() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = 5; 
        assertEquals(5, linearSearch.find(array, key), "The index of the found element should be 5.");
    }

    @Test
    void testLinearSearchFirstElement() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = 0; 
        assertEquals(0, linearSearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testLinearSearchLastElement() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = 10; 
        assertEquals(10, linearSearch.find(array, key), "The index of the last element should be 10.");
    }

    @Test
    void testLinearSearchNotFound() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = -1; 
        assertEquals(-1, linearSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testLinearSearchEmptyArray() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = {}; 
        Integer key = 1; 
        assertEquals(-1, linearSearch.find(array, key), "The element should not be found in an empty array.");
    }

    @Test
    void testLinearSearchLargeArray() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i; 
        }
        Integer key = 256; 
        assertEquals(256, linearSearch.find(array, key), "The index of the found element should be 256.");
    }

    @Test
    void testLinearSearchLargeArrayNotFound() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i; 
        }
        Integer key = 1001; 
        assertEquals(-1, linearSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testLinearSearchMultipleOccurrences() {
        LinearSearch linearSearch = new LinearSearch();
        Integer[] array = {1, 2, 3, 4, 5, 3, 6, 7, 3}; 
        Integer key = 3; 
        assertEquals(2, linearSearch.find(array, key), "The index of the first occurrence of the element should be 2.");
    }

    @Test
    void testLinearSearchRandomArray() {
        LinearSearch linearSearch = new LinearSearch();
        Random random = new Random();
        Integer[] array = random.ints(0, 1000).distinct().limit(1000).boxed().toArray(Integer[] ::new);
        Integer key = array[random.nextInt(array.length)]; 
        assertEquals(java.util.Arrays.asList(array).indexOf(key), linearSearch.find(array, key), "The index of the found element should match.");
    }
}
