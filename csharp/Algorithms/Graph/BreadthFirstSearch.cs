using System;
using System.Collections.Generic;
using DataStructures.Graph;

namespace Algorithms.Graph;

public class BreadthFirstSearch<T> : IGraphSearch<T> where T : IComparable<T>
{
    
    public void VisitAll(IDirectedWeightedGraph<T> graph, Vertex<T> startVertex, Action<Vertex<T>>? action = default)
    {
        Bfs(graph, startVertex, action, new HashSet<Vertex<T>>());
    }

    private void Bfs(IDirectedWeightedGraph<T> graph, Vertex<T> startVertex, Action<Vertex<T>>? action, HashSet<Vertex<T>> visited)
    {
        var queue = new Queue<Vertex<T>>();

        queue.Enqueue(startVertex);

        while (queue.Count > 0)
        {
            var currentVertex = queue.Dequeue();

            if (currentVertex == null || visited.Contains(currentVertex))
            {
                continue;
            }

            foreach (var vertex in graph.GetNeighbors(currentVertex))
            {
                queue.Enqueue(vertex!);
            }

            action?.Invoke(currentVertex);

            visited.Add(currentVertex);
        }
    }
}
