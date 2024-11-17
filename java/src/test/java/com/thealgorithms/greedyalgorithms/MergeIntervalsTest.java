package com.thealgorithms.greedyalgorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeIntervalsTest {

    @Test
    public void testMergeIntervalsWithOverlappingIntervals() {
        
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervalsWithNoOverlap() {
        
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        int[][] expected = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervalsWithCompleteOverlap() {
        
        int[][] intervals = {{1, 5}, {2, 4}, {3, 6}};
        int[][] expected = {{1, 6}};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervalsWithSingleInterval() {
        
        int[][] intervals = {{1, 2}};
        int[][] expected = {{1, 2}};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervalsWithEmptyArray() {
        
        int[][] intervals = {};
        int[][] expected = {};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervalsWithIdenticalIntervals() {
        
        int[][] intervals = {{1, 3}, {1, 3}, {1, 3}};
        int[][] expected = {{1, 3}};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervalsWithRandomIntervals() {
        
        int[][] intervals = {{1, 4}, {5, 7}, {2, 6}, {8, 10}};
        int[][] expected = {{1, 7}, {8, 10}};
        int[][] result = MergeIntervals.merge(intervals);
        assertArrayEquals(expected, result);
    }
}
