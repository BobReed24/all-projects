package com.thealgorithms.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LargestRectangleTest {

    @Test
    void testLargestRectangleHistogramWithTypicalCases() {
        
        int[] heights = {2, 1, 5, 6, 2, 3};
        String expected = "10";
        String result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);

        heights = new int[] {2, 4};
        expected = "4";
        result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);

        heights = new int[] {4, 4, 4, 4};
        expected = "16";
        result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);
    }

    @Test
    void testLargestRectangleHistogramWithEdgeCases() {
        
        int[] heights = {};
        String expected = "0";
        String result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);

        heights = new int[] {5};
        expected = "5";
        result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);

        heights = new int[] {0, 0, 0};
        expected = "0";
        result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);
    }

    @Test
    void testLargestRectangleHistogramWithLargeInput() {
        
        int[] heights = new int[10000];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 1;
        }
        String expected = "10000";
        String result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);
    }

    @Test
    void testLargestRectangleHistogramWithComplexCases() {
        
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        String expected = "12";
        String result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);

        heights = new int[] {2, 1, 5, 6, 2, 3, 1};
        expected = "10";
        result = LargestRectangle.largestRectangleHistogram(heights);
        assertEquals(expected, result);
    }
}
