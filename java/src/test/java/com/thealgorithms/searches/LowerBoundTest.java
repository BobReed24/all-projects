package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LowerBoundTest {

    @Test
    void testLowerBoundElementPresent() {
        Integer[] array = {1, 2, 3, 4, 5};
        LowerBound lowerBound = new LowerBound();

        assertEquals(2, lowerBound.find(array, 3), "Lower bound for 3 should be at index 2");
        assertEquals(0, lowerBound.find(array, 1), "Lower bound for 1 should be at index 0");
        assertEquals(4, lowerBound.find(array, 5), "Lower bound for 5 should be at index 4");
    }

    @Test
    void testLowerBoundElementGreaterThanMax() {
        Integer[] array = {1, 2, 3, 4, 5};
        LowerBound lowerBound = new LowerBound();

        assertEquals(4, lowerBound.find(array, 6), "Lower bound for 6 should be at index 4");
    }

    @Test
    void testLowerBoundElementLessThanMin() {
        Integer[] array = {1, 2, 3, 4, 5};
        LowerBound lowerBound = new LowerBound();

        assertEquals(0, lowerBound.find(array, 0), "Lower bound for 0 should be at index 0");
    }

    @Test
    void testLowerBoundNonExistentValue() {
        Integer[] array = {1, 2, 3, 4, 5};
        LowerBound lowerBound = new LowerBound();

        assertEquals(4, lowerBound.find(array, 7), "Lower bound for 7 should be at index 4");
        assertEquals(0, lowerBound.find(array, 0), "Lower bound for 0 should be at index 0");
    }
}
