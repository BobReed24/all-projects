package com.thealgorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class AStar {
    private AStar() {
    }

    static class Graph {
        private ArrayList<ArrayList<Edge>> graph;

        Graph(int size) {
            this.graph = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                this.graph.add(new ArrayList<>());
            }
        }

        private ArrayList<Edge> getNeighbours(int from) {
            return this.graph.get(from);
        }

        private void addEdge(Edge edge) {
            this.graph.get(edge.getFrom()).add(new Edge(edge.getFrom(), edge.getTo(), edge.getWeight()));
            this.graph.get(edge.getTo()).add(new Edge(edge.getTo(), edge.getFrom(), edge.getWeight()));
        }
    }

    private static class Edge {
        private int from;
        private int to;
        private int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class PathAndDistance {
        private int distance; 
        private ArrayList<Integer> path; 
        private int estimated; 

        PathAndDistance(int distance, ArrayList<Integer> path, int estimated) {
            this.distance = distance;
            this.path = path;
            this.estimated = estimated;
        }

        public int getDistance() {
            return distance;
        }

        public ArrayList<Integer> getPath() {
            return path;
        }

        public int getEstimated() {
            return estimated;
        }
    }

    static void initializeGraph(Graph graph, List<Integer> data) {
        for (int i = 0; i < data.size(); i += 4) {
            graph.addEdge(new Edge(data.get(i), data.get(i + 1), data.get(i + 2)));
        }
    }

    public static PathAndDistance aStar(int from, int to, Graph graph, int[] heuristic) {
        
        PriorityQueue<PathAndDistance> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a.getDistance() + a.getEstimated())));

        queue.add(new PathAndDistance(0, new ArrayList<>(List.of(from)), heuristic[from]));

        boolean solutionFound = false;
        PathAndDistance currentData = new PathAndDistance(-1, null, -1);

        while (!queue.isEmpty() && !solutionFound) {
            currentData = queue.poll(); 
            int currentPosition = currentData.getPath().get(currentData.getPath().size() - 1); 

            if (currentPosition == to) {
                solutionFound = true;
            } else {
                for (Edge edge : graph.getNeighbours(currentPosition)) {
                    
                    if (!currentData.getPath().contains(edge.getTo())) {
                        ArrayList<Integer> updatedPath = new ArrayList<>(currentData.getPath());
                        updatedPath.add(edge.getTo());

                        queue.add(new PathAndDistance(currentData.getDistance() + edge.getWeight(), updatedPath, heuristic[edge.getTo()]));
                    }
                }
            }
        }
        return (solutionFound) ? currentData : new PathAndDistance(-1, null, -1);
    }
}
