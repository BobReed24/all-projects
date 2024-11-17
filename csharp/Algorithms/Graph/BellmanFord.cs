using System;
using System.Collections.Generic;
using DataStructures.Graph;

namespace Algorithms.Graph;

public class BellmanFord<T>
{
    private readonly DirectedWeightedGraph<T> graph;
    private readonly Dictionary<Vertex<T>, double> distances;
    private readonly Dictionary<Vertex<T>, Vertex<T>?> predecessors;

    public BellmanFord(DirectedWeightedGraph<T> graph, Dictionary<Vertex<T>, double> distances, Dictionary<Vertex<T>, Vertex<T>?> predecessors)
    {
        this.graph = graph;
        this.distances = distances;
        this.predecessors = predecessors;
    }

    public Dictionary<Vertex<T>, double> Run(Vertex<T> sourceVertex)
    {
        InitializeDistances(sourceVertex);
        RelaxEdges();
        CheckForNegativeCycles();
        return distances;
    }

    private void InitializeDistances(Vertex<T> sourceVertex)
    {
        foreach (var vertex in graph.Vertices)
        {
            if (vertex != null)
            {
                distances[vertex] = double.PositiveInfinity;
                predecessors[vertex] = null;
            }
        }

        distances[sourceVertex] = 0;
    }

    private void RelaxEdges()
    {
        int vertexCount = graph.Count;

        for (int i = 0; i < vertexCount - 1; i++)
        {
            foreach (var vertex in graph.Vertices)
            {
                if (vertex != null)
                {
                    RelaxEdgesForVertex(vertex);
                }
            }
        }
    }

    private void RelaxEdgesForVertex(Vertex<T> u)
    {
        foreach (var neighbor in graph.GetNeighbors(u))
        {
            if (neighbor == null)
            {
                continue;
            }

            var v = neighbor;
            var weight = graph.AdjacentDistance(u, v);

            if (distances[u] + weight < distances[v])
            {
                distances[v] = distances[u] + weight;
                predecessors[v] = u;
            }
        }
    }

    private void CheckForNegativeCycles()
    {
        foreach (var vertex in graph.Vertices)
        {
            if (vertex != null)
            {
                CheckForNegativeCyclesForVertex(vertex);
            }
        }
    }

    private void CheckForNegativeCyclesForVertex(Vertex<T> u)
    {
        foreach (var neighbor in graph.GetNeighbors(u))
        {
            if (neighbor == null)
            {
                continue;
            }

            var v = neighbor;
            var weight = graph.AdjacentDistance(u, v);

            if (distances[u] + weight < distances[v])
            {
                throw new InvalidOperationException("Graph contains a negative weight cycle.");
            }
        }
    }
}
