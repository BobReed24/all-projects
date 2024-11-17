package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JumpSearchTest {

    @Test
    void testJumpSearchFound() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = 5; 
        assertEquals(5, jumpSearch.find(array, key), "The index of the found element should be 5.");
    }

    @Test
    void testJumpSearchFirstElement() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = 0; 
        assertEquals(0, jumpSearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testJumpSearchLastElement() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = 10; 
        assertEquals(10, jumpSearch.find(array, key), "The index of the last element should be 10.");
    }

    @Test
    void testJumpSearchNotFound() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer key = -1; 
        assertEquals(-1, jumpSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testJumpSearchEmptyArray() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {}; 
        Integer key = 1; 
        assertEquals(-1, jumpSearch.find(array, key), "The element should not be found in an empty array.");
    }

    @Test
    void testJumpSearchLargeArray() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2; 
        }
        Integer key = 256; 
        assertEquals(128, jumpSearch.find(array, key), "The index of the found element should be 128.");
    }

    @Test
    void testJumpSearchLargeArrayNotFound() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2; 
        }
        Integer key = 999; 
        assertEquals(-1, jumpSearch.find(array, key), "The element should not be found in the array.");
    }
}
