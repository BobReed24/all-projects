package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.Node;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BreadthFirstSearchTest {
    private Node<String> root;
    private BreadthFirstSearch<String> bfs;

    @BeforeEach
    public void setUp() {
        
        root = new Node<>("A");

        var nodeB = new Node<>("B");
        var nodeC = new Node<>("C");
        var nodeD = new Node<>("D");

        var nodeE = new Node<>("E");
        var nodeF = new Node<>("F");

        root.addChild(nodeB);
        root.addChild(nodeC);
        root.addChild(nodeD);

        nodeB.addChild(nodeE);
        nodeB.addChild(nodeF);

        bfs = new BreadthFirstSearch<>();
    }

    @Test
    public void testSearchRoot() {
        String expectedValue = "A";
        List<String> expectedPath = List.of("A");

        Optional<Node<String>> value = bfs.search(root, expectedValue);
        assertEquals(expectedValue, value.orElseGet(() -> new Node<>("")).getValue());

        assertArrayEquals(expectedPath.toArray(), bfs.getVisited().toArray());
    }

    @Test
    public void testSearchF() {
        String expectedValue = "F";
        List<String> expectedPath = List.of("A", "B", "C", "D", "E", "F");

        Optional<Node<String>> value = Optional.of(bfs.search(root, expectedValue).orElseGet(() -> new Node<>(null)));
        assertEquals(expectedValue, value.get().getValue());

        assertArrayEquals(expectedPath.toArray(), bfs.getVisited().toArray());
    }

    @Test
    void testSearchNull() {
        List<String> expectedPath = List.of("A", "B", "C", "D", "E", "F");
        Optional<Node<String>> node = bfs.search(root, null);

        assertTrue(node.isEmpty());

        assertArrayEquals(expectedPath.toArray(), bfs.getVisited().toArray());
    }

    @Test
    void testNullRoot() {
        var value = bfs.search(null, "B");
        assertTrue(value.isEmpty());
    }

    @Test
    void testSearchValueThatNotExists() {
        List<String> expectedPath = List.of("A", "B", "C", "D", "E", "F");
        var value = bfs.search(root, "Z");

        assertTrue(value.isEmpty());

        assertArrayEquals(expectedPath.toArray(), bfs.getVisited().toArray());
    }
}
