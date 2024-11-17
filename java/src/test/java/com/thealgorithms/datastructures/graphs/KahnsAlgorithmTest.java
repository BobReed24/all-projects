package com.thealgorithms.datastructures.graphs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class KahnsAlgorithmTest {

    @Test
    void testBasicGraph() {
        
        AdjacencyList<String> graph = new AdjacencyList<>();
        graph.addEdge("a", "b");
        graph.addEdge("c", "a");
        graph.addEdge("a", "d");
        graph.addEdge("b", "d");

        TopologicalSort<String> topSort = new TopologicalSort<>(graph);
        ArrayList<String> result = topSort.topSortOrder();

        String[] expectedOrder = {"c", "a", "b", "d"};
        assertArrayEquals(expectedOrder, result.toArray());
    }

    @Test
    void testGraphWithMultipleSources() {
        
        AdjacencyList<String> graph = new AdjacencyList<>();
        graph.addEdge("a", "c");
        graph.addEdge("b", "c");

        TopologicalSort<String> topSort = new TopologicalSort<>(graph);
        ArrayList<String> result = topSort.topSortOrder();

        String[] expectedOrder = {"a", "b", "c"};
        assertArrayEquals(expectedOrder, result.toArray());
    }

    @Test
    void testDisconnectedGraph() {
        
        AdjacencyList<String> graph = new AdjacencyList<>();
        graph.addEdge("a", "b");
        graph.addEdge("c", "d");

        TopologicalSort<String> topSort = new TopologicalSort<>(graph);
        ArrayList<String> result = topSort.topSortOrder();

        String[] expectedOrder = {"a", "c", "b", "d"};
        assertArrayEquals(expectedOrder, result.toArray());
    }

    @Test
    void testGraphWithCycle() {
        
        AdjacencyList<String> graph = new AdjacencyList<>();
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("c", "a");

        TopologicalSort<String> topSort = new TopologicalSort<>(graph);

        assertThrows(IllegalStateException.class, () -> topSort.topSortOrder());
    }

    @Test
    void testSingleNodeGraph() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        graph.addEdge("a", "a"); 

        TopologicalSort<String> topSort = new TopologicalSort<>(graph);

        assertThrows(IllegalStateException.class, () -> topSort.topSortOrder());
    }
}
