package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumSlidingWindowTest {

    MaximumSlidingWindow msw;
    int[] nums;
    int k;

    @BeforeEach
    void setUp() {
        msw = new MaximumSlidingWindow(); 
    }

    @Test
    void testMaxSlidingWindowSimpleCase() {
        nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, msw.maxSlidingWindow(nums, k));
    }

    @Test
    void testMaxSlidingWindowWindowSizeOne() {
        nums = new int[] {4, 2, 12, 11, -5};
        k = 1;
        int[] expected = {4, 2, 12, 11, -5};
        assertArrayEquals(expected, msw.maxSlidingWindow(nums, k));
    }

    @Test
    void testMaxSlidingWindowWindowSizeEqualsArrayLength() {
        nums = new int[] {4, 2, 12, 11, -5};
        k = nums.length;
        int[] expected = {12}; 
        assertArrayEquals(expected, msw.maxSlidingWindow(nums, k));
    }

    @Test
    void testMaxSlidingWindowEmptyArray() {
        nums = new int[] {};
        k = 3;
        int[] expected = {};
        assertArrayEquals(expected, msw.maxSlidingWindow(nums, k));
    }

    @Test
    void testMaxSlidingWindowWindowSizeLargerThanArray() {
        nums = new int[] {1, 2, 3};
        k = 5;
        int[] expected = {}; 
        assertArrayEquals(expected, msw.maxSlidingWindow(nums, k));
    }
}
