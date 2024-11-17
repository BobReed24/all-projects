package com.thealgorithms.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StronglyConnectedComponentOptimizedTest {

    private StronglyConnectedComponentOptimized sccOptimized;

    @BeforeEach
    public void setUp() {
        sccOptimized = new StronglyConnectedComponentOptimized();
    }

    @Test
    public void testSingleComponent() {
        
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, new ArrayList<>(List.of(1)));
        adjList.put(1, new ArrayList<>(List.of(2)));
        adjList.put(2, new ArrayList<>(List.of(0)));

        int result = sccOptimized.getOutput(adjList, 3);

        assertEquals(1, result, "There should be 1 strongly connected component.");
    }

    @Test
    public void testTwoComponents() {
        
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, new ArrayList<>(List.of(1)));
        adjList.put(1, new ArrayList<>(List.of(2)));
        adjList.put(2, new ArrayList<>(List.of(0)));
        adjList.put(3, new ArrayList<>());

        int result = sccOptimized.getOutput(adjList, 4);

        assertEquals(2, result, "There should be 2 strongly connected components.");
    }

    @Test
    public void testDisconnectedGraph() {
        
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, new ArrayList<>());
        adjList.put(1, new ArrayList<>());
        adjList.put(2, new ArrayList<>());
        adjList.put(3, new ArrayList<>());

        int result = sccOptimized.getOutput(adjList, 4);

        assertEquals(4, result, "There should be 4 strongly connected components.");
    }

    @Test
    public void testComplexGraph() {
        
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, new ArrayList<>(List.of(1)));
        adjList.put(1, new ArrayList<>(List.of(2)));
        adjList.put(2, new ArrayList<>(List.of(0, 3)));
        adjList.put(3, new ArrayList<>(List.of(4)));
        adjList.put(4, new ArrayList<>(List.of(5)));
        adjList.put(5, new ArrayList<>(List.of(3)));

        int result = sccOptimized.getOutput(adjList, 6);

        assertEquals(2, result, "There should be 2 strongly connected components.");
    }
}
