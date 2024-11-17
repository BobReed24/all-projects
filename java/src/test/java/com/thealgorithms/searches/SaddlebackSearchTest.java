package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SaddlebackSearchTest {

    @Test
    void testFindElementExists() {
        int[][] arr = {{-10, -5, -3, 4, 9}, {-6, -2, 0, 5, 10}, {-4, -1, 1, 6, 12}, {2, 3, 7, 8, 13}, {100, 120, 130, 140, 150}};

        int[] result = SaddlebackSearch.find(arr, arr.length - 1, 0, 4);
        assertArrayEquals(new int[] {0, 3}, result, "Element 4 should be found at (0, 3)");
    }

    @Test
    void testFindElementNotExists() {
        int[][] arr = {{-10, -5, -3, 4, 9}, {-6, -2, 0, 5, 10}, {-4, -1, 1, 6, 12}, {2, 3, 7, 8, 13}, {100, 120, 130, 140, 150}};

        int[] result = SaddlebackSearch.find(arr, arr.length - 1, 0, 1000);
        assertArrayEquals(new int[] {-1, -1}, result, "Element 1000 should not be found");
    }

    @Test
    void testFindSmallestElement() {
        int[][] arr = {{-10, -5, -3, 4, 9}, {-6, -2, 0, 5, 10}, {-4, -1, 1, 6, 12}, {2, 3, 7, 8, 13}, {100, 120, 130, 140, 150}};

        int[] result = SaddlebackSearch.find(arr, arr.length - 1, 0, -10);
        assertArrayEquals(new int[] {0, 0}, result, "Element -10 should be found at (0, 0)");
    }

    @Test
    void testFindLargestElement() {
        int[][] arr = {{-10, -5, -3, 4, 9}, {-6, -2, 0, 5, 10}, {-4, -1, 1, 6, 12}, {2, 3, 7, 8, 13}, {100, 120, 130, 140, 150}};

        int[] result = SaddlebackSearch.find(arr, arr.length - 1, 0, 150);
        assertArrayEquals(new int[] {4, 4}, result, "Element 150 should be found at (4, 4)");
    }

    @Test
    void testFindInEmptyArray() {
        int[][] arr = {};

        assertThrows(IllegalArgumentException.class, () -> { SaddlebackSearch.find(arr, 0, 0, 4); });
    }

    @Test
    void testFindSingleElementExists() {
        int[][] arr = {{5}};

        int[] result = SaddlebackSearch.find(arr, 0, 0, 5);
        assertArrayEquals(new int[] {0, 0}, result, "Element 5 should be found at (0, 0)");
    }

    @Test
    void testFindSingleElementNotExists() {
        int[][] arr = {{5}};

        int[] result = SaddlebackSearch.find(arr, 0, 0, 10);
        assertArrayEquals(new int[] {-1, -1}, result, "Element 10 should not be found in single element array");
    }
}
