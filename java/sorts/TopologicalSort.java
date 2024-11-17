package com.thealgorithms.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class TopologicalSort {
    private TopologicalSort() {
    }

    private enum Color {
        WHITE,
        GRAY,
        BLACK,
    }

    private static class Vertex {

        public final String label;

        public Color color = Color.WHITE;

        public final ArrayList<String> next = new ArrayList<>();

        Vertex(String label) {
            this.label = label;
        }
    }

    static class Graph {

        private final HashMap<String, Vertex> adj = new LinkedHashMap<>();

        public void addEdge(String label, String... next) {
            adj.put(label, new Vertex(label));
            if (!next[0].isEmpty()) {
                Collections.addAll(adj.get(label).next, next);
            }
        }
    }

    public static LinkedList<String> sort(Graph graph) {
        LinkedList<String> list = new LinkedList<>();
        graph.adj.forEach((name, vertex) -> {
            if (vertex.color == Color.WHITE) {
                list.addFirst(sort(graph, vertex, list));
            }
        });
        return list;
    }

    private static String sort(Graph graph, Vertex u, LinkedList<String> list) {
        u.color = Color.GRAY;
        graph.adj.get(u.label).next.forEach(label -> {
            if (graph.adj.get(label).color == Color.WHITE) {
                list.addFirst(sort(graph, graph.adj.get(label), list));
            } else if (graph.adj.get(label).color == Color.GRAY) {
                
                throw new RuntimeException("This graph contains a cycle. No linear ordering is possible. Back edge: " + u.label + " -> " + label);
            }
        });
        u.color = Color.BLACK;
        return u.label;
    }
}
