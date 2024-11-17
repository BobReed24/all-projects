package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class InterpolationSearchTest {

    @Test
    void testInterpolationSearchFound() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        int key = 128;
        int expectedIndex = 7; 
        assertEquals(expectedIndex, interpolationSearch.find(array, key), "The index of the found element should be 7.");
    }

    @Test
    void testInterpolationSearchNotFound() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = {1, 2, 4, 8, 16};
        int key = 6; 
        assertEquals(-1, interpolationSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testInterpolationSearchFirstElement() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = {1, 2, 4, 8, 16};
        int key = 1; 
        assertEquals(0, interpolationSearch.find(array, key), "The index of the first element should be 0.");
    }

    @Test
    void testInterpolationSearchSingleElementNotFound() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = {1};
        int key = 2; 
        assertEquals(-1, interpolationSearch.find(array, key), "The element should not be found in the array.");
    }

    @Test
    void testInterpolationSearchEmptyArray() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = {}; 
        int key = 1; 
        assertEquals(-1, interpolationSearch.find(array, key), "The element should not be found in an empty array.");
    }

    @Test
    void testInterpolationSearchLargeUniformArray() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = IntStream.range(0, 10000).map(i -> i * 2).toArray(); 
        int key = 9998; 
        assertEquals(4999, interpolationSearch.find(array, key), "The index of the last element should be 4999.");
    }

    @Test
    void testInterpolationSearchLargeNonUniformArray() {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] array = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144}; 
        int key = 21; 
        assertEquals(6, interpolationSearch.find(array, key), "The index of the found element should be 6.");
    }
}
