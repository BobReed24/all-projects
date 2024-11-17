package com.thealgorithms.datastructures.graphs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class JohnsonsAlgorithmTest {

    private static final double INF = Double.POSITIVE_INFINITY;

    @Test
    void testSimpleGraph() {
        double[][] graph = {{0, 4, INF, INF}, {INF, 0, 1, INF}, {INF, INF, 0, 2}, {INF, INF, INF, 0}};
        double[][] result = JohnsonsAlgorithm.johnsonAlgorithm(graph);
        double[][] expected = {{0, 4, 5, 7}, {INF, 0, 1, 3}, {INF, INF, 0, 2}, {INF, INF, INF, 0}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testGraphWithNegativeEdges() {
        double[][] graph = {{0, -1, 4}, {INF, 0, 3}, {INF, INF, 0}};
        double[][] result = JohnsonsAlgorithm.johnsonAlgorithm(graph);
        double[][] expected = {{0, INF, 4}, {INF, 0, 3}, {INF, INF, 0}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testNegativeWeightCycle() {
        double[][] graph = {{0, 1, INF}, {INF, 0, -1}, {-1, INF, 0}};
        assertThrows(IllegalArgumentException.class, () -> JohnsonsAlgorithm.johnsonAlgorithm(graph));
    }

    @Test
    void testDijkstra() {
        double[][] graph = {{0, 1, 2}, {INF, 0, 3}, {INF, INF, 0}};
        double[] modifiedWeights = {0, 0, 0};
        double[] result = JohnsonsAlgorithm.dijkstra(graph, 0, modifiedWeights);
        double[] expected = {0, 1, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    void testEdgeListConversion() {
        double[][] graph = {{0, 5, INF}, {INF, 0, 2}, {INF, INF, 0}};
        double[][] edges = JohnsonsAlgorithm.convertToEdgeList(graph);
        double[][] expected = {{0, 1, 5}, {1, 2, 2}};
        assertArrayEquals(expected, edges);
    }

    @Test
    void testReweightGraph() {
        double[][] graph = {{0, 2, 9}, {INF, 0, 1}, {INF, INF, 0}};
        double[] modifiedWeights = {1, 2, 3};
        double[][] reweightedGraph = JohnsonsAlgorithm.reweightGraph(graph, modifiedWeights);
        double[][] expected = {{0, 1, 7}, {INF, 0, 0}, {INF, INF, 0}};
        assertArrayEquals(expected, reweightedGraph);
    }

    @Test
    void testMinDistance() {
        double[] dist = {INF, 3, 1, INF};
        boolean[] visited = {false, false, false, false};
        int minIndex = JohnsonsAlgorithm.minDistance(dist, visited);
        assertEquals(2, minIndex);
    }

    @Test
    void testDisconnectedGraph() {
        double[][] graph = {{0, INF, INF}, {INF, 0, INF}, {INF, INF, 0}};
        double[][] result = JohnsonsAlgorithm.johnsonAlgorithm(graph);
        double[][] expected = {{0, INF, INF}, {INF, 0, INF}, {INF, INF, 0}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testFullyConnectedGraph() {
        double[][] graph = {{0, 1, 2}, {1, 0, 1}, {2, 1, 0}};
        double[][] result = JohnsonsAlgorithm.johnsonAlgorithm(graph);
        double[][] expected = {{0, 1, 2}, {1, 0, 1}, {2, 1, 0}};
        assertArrayEquals(expected, result);
    }

    @Test
    void testDijkstraMultipleShortestPaths() {
        double[][] graph = {{0, 1, 2, INF}, {INF, 0, INF, 1}, {INF, INF, 0, 1}, {INF, INF, INF, 0}};
        double[] modifiedWeights = {0, 0, 0, 0};
        double[] result = JohnsonsAlgorithm.dijkstra(graph, 0, modifiedWeights);
        double[] expected = {0, 1, 2, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    void testGraphWithZeroWeights() {
        double[][] graph = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        double[][] result = JohnsonsAlgorithm.johnsonAlgorithm(graph);
        double[][] expected = {{0, INF, INF}, {INF, 0, INF}, {INF, INF, 0}};
        assertArrayEquals(expected, result);
    }
}
