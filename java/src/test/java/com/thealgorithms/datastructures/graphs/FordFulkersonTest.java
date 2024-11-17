package com.thealgorithms.datastructures.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FordFulkersonTest {
    @Test
    public void testMaxFlow() {
        int vertexCount = 6;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 12;
        capacity[0][3] = 13;
        capacity[1][2] = 10;
        capacity[2][3] = 13;
        capacity[2][4] = 3;
        capacity[2][5] = 15;
        capacity[3][2] = 7;
        capacity[3][4] = 15;
        capacity[4][5] = 17;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 5);
        assertEquals(23, maxFlow);
    }

    @Test
    public void testNoFlow() {
        int vertexCount = 6;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10;
        capacity[2][3] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 1, 4);
        assertEquals(0, maxFlow);
    }

    @Test
    public void testSinglePath() {
        int vertexCount = 6;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 5;
        capacity[1][2] = 5;
        capacity[2][3] = 5;
        capacity[3][4] = 5;
        capacity[4][5] = 5;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 5);
        assertEquals(5, maxFlow);
    }

    @Test
    public void testParallelPaths() {
        int vertexCount = 4;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10;
        capacity[0][2] = 10;
        capacity[1][3] = 10;
        capacity[2][3] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 3);
        assertEquals(20, maxFlow);
    }

    @Test
    public void testComplexNetwork() {
        int vertexCount = 5;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10;
        capacity[0][2] = 10;
        capacity[1][3] = 4;
        capacity[1][4] = 8;
        capacity[2][4] = 9;
        capacity[3][2] = 6;
        capacity[3][4] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 4);
        assertEquals(19, maxFlow);
    }

    @Test
    public void testLargeNetwork() {
        int vertexCount = 8;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10;
        capacity[0][2] = 5;
        capacity[1][3] = 15;
        capacity[2][3] = 10;
        capacity[1][4] = 10;
        capacity[3][5] = 10;
        capacity[4][5] = 5;
        capacity[4][6] = 10;
        capacity[5][7] = 10;
        capacity[6][7] = 15;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 7);
        assertEquals(15, maxFlow); 
    }

    @Test
    public void testMultipleSourcesAndSinks() {
        int vertexCount = 7;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10; 
        capacity[0][2] = 5;
        capacity[1][3] = 15;
        capacity[2][3] = 10;
        capacity[3][4] = 10; 
        capacity[3][5] = 5;
        capacity[3][6] = 10; 
        capacity[5][6] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 4);
        assertEquals(10, maxFlow); 
    }

    @Test
    public void testDisconnectedGraph() {
        int vertexCount = 6;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10; 
        capacity[1][2] = 10;
        capacity[3][4] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 5);
        assertEquals(0, maxFlow); 
    }

    @Test
    public void testZeroCapacityEdge() {
        int vertexCount = 4;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10;
        capacity[0][2] = 0; 
        capacity[1][3] = 5;
        capacity[2][3] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 3);
        assertEquals(5, maxFlow); 
    }

    @Test
    public void testAllEdgesZeroCapacity() {
        int vertexCount = 5;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 0;
        capacity[1][2] = 0;
        capacity[2][3] = 0;
        capacity[3][4] = 0;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 4);
        assertEquals(0, maxFlow); 
    }

    @Test
    public void testCycleGraph() {
        int vertexCount = 4;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 10;
        capacity[1][2] = 5;
        capacity[2][0] = 5; 
        capacity[1][3] = 15;
        capacity[2][3] = 10;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 3);
        assertEquals(10, maxFlow); 
    }

    @Test
    public void testFlowWithExcessCapacity() {
        int vertexCount = 5;
        int[][] capacity = new int[vertexCount][vertexCount];
        int[][] flow = new int[vertexCount][vertexCount];

        capacity[0][1] = 20;
        capacity[1][2] = 10;
        capacity[2][3] = 15;
        capacity[1][3] = 5;

        int maxFlow = FordFulkerson.networkFlow(vertexCount, capacity, flow, 0, 3);
        assertEquals(15, maxFlow); 
    }
}
