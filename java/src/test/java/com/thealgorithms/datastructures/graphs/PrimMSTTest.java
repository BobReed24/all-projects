package com.thealgorithms.datastructures.graphs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class PrimMSTTest {

    private final PrimMST primMST = new PrimMST();

    @Test
    public void testSimpleGraph() {
        
        int[][] graph = {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};

        int[] expectedParent = {-1, 0, 1, 0, 1};
        int[] actualParent = primMST.primMST(graph);

        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testDisconnectedGraph() {
        
        int[][] graph = {{0, 1, 0, 0, 0}, {1, 0, 2, 0, 0}, {0, 2, 0, 3, 0}, {0, 0, 3, 0, 4}, {0, 0, 0, 4, 0}};

        int[] expectedParent = {-1, 0, 1, 2, 3}; 
        int[] actualParent = primMST.primMST(graph);

        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testAllEqualWeightsGraph() {
        
        int[][] graph = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};

        int[] expectedParent = {-1, 0, 0, 0, 0}; 
        int[] actualParent = primMST.primMST(graph);

        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testSparseGraph() {
        
        int[][] graph = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}};

        int[] expectedParent = {-1, 0, 1, 2, 3}; 
        int[] actualParent = primMST.primMST(graph);

        assertArrayEquals(expectedParent, actualParent);
    }
}
