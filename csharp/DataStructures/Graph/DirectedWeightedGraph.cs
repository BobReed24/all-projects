using System;
using System.Collections.Generic;

namespace DataStructures.Graph;

public class DirectedWeightedGraph<T> : IDirectedWeightedGraph<T>
{
    
    private readonly int capacity;

    private readonly double[,] adjacencyMatrix;

    public DirectedWeightedGraph(int capacity)
    {
        ThrowIfNegativeCapacity(capacity);

        this.capacity = capacity;
        Vertices = new Vertex<T>[capacity];
        adjacencyMatrix = new double[capacity, capacity];
        Count = 0;
    }

    public Vertex<T>?[] Vertices { get; private set; }

    public int Count { get; private set; }

    public Vertex<T> AddVertex(T data)
    {
        ThrowIfOverflow();
        var vertex = new Vertex<T>(data, Count, this);
        Vertices[Count] = vertex;
        Count++;
        return vertex;
    }

    public void AddEdge(Vertex<T> startVertex, Vertex<T> endVertex, double weight)
    {
        ThrowIfVertexNotInGraph(startVertex);
        ThrowIfVertexNotInGraph(endVertex);

        ThrowIfWeightZero(weight);

        var currentEdgeWeight = adjacencyMatrix[startVertex.Index, endVertex.Index];

        ThrowIfEdgeExists(currentEdgeWeight);

        adjacencyMatrix[startVertex.Index, endVertex.Index] = weight;
    }

    public void RemoveVertex(Vertex<T> vertex)
    {
        ThrowIfVertexNotInGraph(vertex);

        int indexToRemove = vertex.Index;
        vertex.Index = -1;
        vertex.SetGraphNull();

        for (int i = indexToRemove; i < Count - 1; i++)
        {
            Vertices[i] = Vertices[i + 1];
            Vertices[i]!.Index = i;
        }

        Vertices[Count - 1] = null;

        for (int i = 0; i < Count; i++)
        {
            for (int j = 0; j < Count; j++)
            {
                if (i < indexToRemove && j < indexToRemove)
                {
                    continue;
                }
                else if (i < indexToRemove && j >= indexToRemove && j < Count - 1)
                {
                    adjacencyMatrix[i, j] = adjacencyMatrix[i, j + 1];
                }
                else if (i >= indexToRemove && i < Count - 1 && j < indexToRemove)
                {
                    adjacencyMatrix[i, j] = adjacencyMatrix[i + 1, j];
                }
                else if (i >= indexToRemove && i < Count - 1 && j >= indexToRemove && j < Count - 1)
                {
                    adjacencyMatrix[i, j] = adjacencyMatrix[i + 1, j + 1];
                }
                else if (i == Count - 1 || j == Count - 1)
                {
                    adjacencyMatrix[i, j] = 0;
                }
                else
                {
                    throw new InvalidOperationException();
                }
            }
        }

        Count--;
    }

    public void RemoveEdge(Vertex<T> startVertex, Vertex<T> endVertex)
    {
        ThrowIfVertexNotInGraph(startVertex);
        ThrowIfVertexNotInGraph(endVertex);
        adjacencyMatrix[startVertex.Index, endVertex.Index] = 0;
    }

    public IEnumerable<Vertex<T>?> GetNeighbors(Vertex<T> vertex)
    {
        ThrowIfVertexNotInGraph(vertex);

        for (var i = 0; i < Count; i++)
        {
            if (adjacencyMatrix[vertex.Index, i] != 0)
            {
                yield return Vertices[i];
            }
        }
    }

    public bool AreAdjacent(Vertex<T> startVertex, Vertex<T> endVertex)
    {
        ThrowIfVertexNotInGraph(startVertex);
        ThrowIfVertexNotInGraph(endVertex);

        return adjacencyMatrix[startVertex.Index, endVertex.Index] != 0;
    }

    public double AdjacentDistance(Vertex<T> startVertex, Vertex<T> endVertex)
    {
        if (AreAdjacent(startVertex, endVertex))
        {
            return adjacencyMatrix[startVertex.Index, endVertex.Index];
        }

        return 0;
    }

    private static void ThrowIfNegativeCapacity(int capacity)
    {
        if (capacity < 0)
        {
            throw new InvalidOperationException("Graph capacity should always be a non-negative integer.");
        }
    }

    private static void ThrowIfWeightZero(double weight)
    {
        if (weight.Equals(0.0d))
        {
            throw new InvalidOperationException("Edge weight cannot be zero.");
        }
    }

    private static void ThrowIfEdgeExists(double currentEdgeWeight)
    {
        if (!currentEdgeWeight.Equals(0.0d))
        {
            throw new InvalidOperationException($"Vertex already exists: {currentEdgeWeight}");
        }
    }

    private void ThrowIfOverflow()
    {
        if (Count == capacity)
        {
            throw new InvalidOperationException("Graph overflow.");
        }
    }

    private void ThrowIfVertexNotInGraph(Vertex<T> vertex)
    {
        if (vertex.Graph != this)
        {
            throw new InvalidOperationException($"Vertex does not belong to graph: {vertex}.");
        }
    }
}
