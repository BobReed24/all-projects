package com.thealgorithms.sorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.thealgorithms.sorts.TopologicalSort.Graph;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class TopologicalSortTest {

    @Test
    void successTest() {
        
        Graph graph = new Graph();
        graph.addEdge("shirt", "tie", "belt");
        graph.addEdge("tie", "jacket");
        graph.addEdge("belt", "jacket");
        graph.addEdge("watch", "");
        graph.addEdge("undershorts", "pants", "shoes");
        graph.addEdge("shoes", "");
        graph.addEdge("socks", "shoes");
        graph.addEdge("jacket", "");
        graph.addEdge("pants", "belt", "shoes");
        LinkedList<String> expected = new LinkedList<>();
        expected.add("socks");
        expected.add("undershorts");
        expected.add("pants");
        expected.add("shoes");
        expected.add("watch");
        expected.add("shirt");
        expected.add("belt");
        expected.add("tie");
        expected.add("jacket");
        assertIterableEquals(expected, TopologicalSort.sort(graph));
    }

    @Test
    public void failureTest() {
        
        Graph graph = new Graph();
        graph.addEdge("1", "2", "3", "8");
        graph.addEdge("2", "4");
        graph.addEdge("3", "5");
        graph.addEdge("4", "6");
        graph.addEdge("5", "4", "7", "8");
        graph.addEdge("6", "2");
        graph.addEdge("7", "");
        graph.addEdge("8", "");
        Exception exception = assertThrows(RuntimeException.class, () -> TopologicalSort.sort(graph));
        String expected = "This graph contains a cycle. No linear ordering is possible. "
            + "Back edge: 6 -> 2";
        assertEquals(exception.getMessage(), expected);
    }
}
