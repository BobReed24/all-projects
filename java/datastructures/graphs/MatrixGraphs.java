package com.thealgorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class MatrixGraphs {
    private MatrixGraphs() {
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 9);
        graph.addEdge(9, 1);
        graph.addEdge(9, 8);
        graph.addEdge(1, 8);
        graph.addEdge(5, 6);
        System.out.println("The graph matrix:");
        System.out.println(graph);
        System.out.println("Depth first order beginning at node '1':");
        System.out.println(graph.depthFirstOrder(1));
        System.out.println("Breadth first order beginning at node '1':");
        System.out.println(graph.breadthFirstOrder(1));
    }
}

class AdjacencyMatrixGraph {

    private int vertexCount;

    private int edgeCount;

    private int[][] adjMatrix;

    static final int EDGE_EXIST = 1;
    static final int EDGE_NONE = 0;

    AdjacencyMatrixGraph(int givenNumberOfVertices) {
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
        for (int i = 0; i < givenNumberOfVertices; i++) {
            for (int j = 0; j < givenNumberOfVertices; j++) {
                this.adjacency()[i][j] = AdjacencyMatrixGraph.EDGE_NONE;
            }
        }
    }

    private void setNumberOfVertices(int newNumberOfVertices) {
        this.vertexCount = newNumberOfVertices;
    }

    public int numberOfVertices() {
        return this.vertexCount;
    }

    private void setNumberOfEdges(int newNumberOfEdges) {
        this.edgeCount = newNumberOfEdges;
    }

    public int numberOfEdges() {
        return this.edgeCount;
    }

    private void setAdjacency(int[][] newAdjacency) {
        this.adjMatrix = newAdjacency;
    }

    private int[][] adjacency() {
        return this.adjMatrix;
    }

    private boolean adjacencyOfEdgeDoesExist(int from, int to) {
        return (this.adjacency()[from][to] != AdjacencyMatrixGraph.EDGE_NONE);
    }

    public boolean vertexDoesExist(int aVertex) {
        return aVertex >= 0 && aVertex < this.numberOfVertices();
    }

    public boolean edgeDoesExist(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            return (this.adjacencyOfEdgeDoesExist(from, to));
        }

        return false;
    }

    public boolean addEdge(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            if (!this.adjacencyOfEdgeDoesExist(from, to)) {
                this.adjacency()[from][to] = AdjacencyMatrixGraph.EDGE_EXIST;
                this.adjacency()[to][from] = AdjacencyMatrixGraph.EDGE_EXIST;
                this.setNumberOfEdges(this.numberOfEdges() + 1);
                return true;
            }
        }

        return false;
    }

    public boolean removeEdge(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            if (this.adjacencyOfEdgeDoesExist(from, to)) {
                this.adjacency()[from][to] = AdjacencyMatrixGraph.EDGE_NONE;
                this.adjacency()[to][from] = AdjacencyMatrixGraph.EDGE_NONE;
                this.setNumberOfEdges(this.numberOfEdges() - 1);
                return true;
            }
        }
        return false;
    }

    public List<Integer> depthFirstOrder(int startVertex) {
        
        if (startVertex >= vertexCount || startVertex < 0) {
            return new ArrayList<>();
        }

        boolean[] visited = new boolean[vertexCount];

        ArrayList<Integer> orderList = new ArrayList<>();

        depthFirstOrder(startVertex, visited, orderList);

        return orderList;
    }

    private void depthFirstOrder(int currentVertex, boolean[] visited, List<Integer> orderList) {
        
        if (visited[currentVertex]) {
            return;
        }

        visited[currentVertex] = true;
        orderList.add(currentVertex);

        int[] adjacent = adjMatrix[currentVertex];
        for (int i = 0; i < adjacent.length; i++) { 
                                                    
            if (adjacent[i] == AdjacencyMatrixGraph.EDGE_EXIST) {
                depthFirstOrder(i, visited, orderList);
            }
        }
    }

    public List<Integer> breadthFirstOrder(int startVertex) {
        
        if (startVertex >= vertexCount || startVertex < 0) {
            return new ArrayList<>();
        }

        boolean[] visited = new boolean[vertexCount];

        ArrayList<Integer> orderList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            
            int currentVertex = queue.poll();

            if (visited[currentVertex]) {
                continue;
            }

            orderList.add(currentVertex);
            visited[currentVertex] = true;

            int[] adjacent = adjMatrix[currentVertex];
            for (int vertex = 0; vertex < adjacent.length; vertex++) { 
                                                                       
                if (adjacent[vertex] == AdjacencyMatrixGraph.EDGE_EXIST) {
                    queue.add(vertex);
                }
            }
        }

        return orderList;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("    ");
        for (int i = 0; i < this.numberOfVertices(); i++) {
            s.append(i).append(" ");
        }
        s.append(" \n");

        for (int i = 0; i < this.numberOfVertices(); i++) {
            s.append(i).append(" : ");
            for (int j = 0; j < this.numberOfVertices(); j++) {
                s.append(this.adjMatrix[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
