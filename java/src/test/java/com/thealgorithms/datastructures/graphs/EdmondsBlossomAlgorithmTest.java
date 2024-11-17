package com.thealgorithms.datastructures.graphs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EdmondsBlossomAlgorithmTest {

    private int[][] convertMatchingToArray(Collection<int[]> matching) {
        
        int[][] result = matching.toArray(new int[0][]);

        for (int[] pair : result) {
            Arrays.sort(pair);
        }

        Arrays.sort(result, (a, b) -> Integer.compare(a[0], b[0]));
        return result;
    }

    @Test
    public void testCase1() {
        List<int[]> edges = Arrays.asList(new int[] {0, 1}, new int[] {1, 2}, new int[] {2, 0});
        List<int[]> matching = EdmondsBlossomAlgorithm.maximumMatching(edges, 3);

        int[][] expected = new int[][] {{0, 1}};
        assertArrayEquals(expected, convertMatchingToArray(matching));
    }

    @Test
    public void testCase2() {
        List<int[]> edges = Arrays.asList(new int[] {0, 1}, new int[] {1, 2}, new int[] {3, 4});
        List<int[]> matching = EdmondsBlossomAlgorithm.maximumMatching(edges, 5);

        int[][] expected = new int[][] {{0, 1}, {3, 4}};
        assertArrayEquals(expected, convertMatchingToArray(matching));
    }

    @Test
    public void testCase3() {
        List<int[]> edges = Arrays.asList(new int[] {0, 1}, new int[] {1, 2}, new int[] {2, 3}, new int[] {3, 0}, new int[] {4, 5});
        List<int[]> matching = EdmondsBlossomAlgorithm.maximumMatching(edges, 6);

        int[][] expected = new int[][] {{0, 1}, {2, 3}, {4, 5}};
        assertArrayEquals(expected, convertMatchingToArray(matching));
    }

    @Test
    public void testCaseNoMatching() {
        List<int[]> edges = Collections.emptyList(); 
        List<int[]> matching = EdmondsBlossomAlgorithm.maximumMatching(edges, 3);

        int[][] expected = new int[][] {}; 
        assertArrayEquals(expected, convertMatchingToArray(matching));
    }

    @Test
    public void testCaseLargeGraph() {
        List<int[]> edges = Arrays.asList(new int[] {0, 1}, new int[] {1, 2}, new int[] {2, 3}, new int[] {3, 4}, new int[] {4, 5}, new int[] {5, 0}, new int[] {1, 4}, new int[] {2, 5});
        List<int[]> matching = EdmondsBlossomAlgorithm.maximumMatching(edges, 6);

        assertEquals(3, matching.size());

        int[][] possibleMatching1 = new int[][] {{0, 1}, {2, 5}, {3, 4}};
        int[][] possibleMatching2 = new int[][] {{0, 1}, {2, 3}, {4, 5}};
        int[][] result = convertMatchingToArray(matching);

        assertTrue(Arrays.deepEquals(result, possibleMatching1) || Arrays.deepEquals(result, possibleMatching2));
    }
}
