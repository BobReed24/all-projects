using System;
using System.Collections.Generic;
using DataStructures.Graph;

namespace Algorithms.Graph;

public class DepthFirstSearch<T> : IGraphSearch<T> where T : IComparable<T>
{
    
    public void VisitAll(IDirectedWeightedGraph<T> graph, Vertex<T> startVertex, Action<Vertex<T>>? action = default)
    {
        Dfs(graph, startVertex, action, new HashSet<Vertex<T>>());
    }

    private void Dfs(IDirectedWeightedGraph<T> graph, Vertex<T> startVertex, Action<Vertex<T>>? action, HashSet<Vertex<T>> visited)
    {
        action?.Invoke(startVertex);

        visited.Add(startVertex);

        foreach (var vertex in graph.GetNeighbors(startVertex))
        {
            if (vertex == null || visited.Contains(vertex))
            {
                continue;
            }

            Dfs(graph, vertex!, action, visited);
        }
    }
}
