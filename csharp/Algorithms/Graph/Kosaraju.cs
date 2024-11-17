using System.Collections.Generic;
using System.Linq;
using DataStructures.Graph;

namespace Algorithms.Graph;

public static class Kosaraju<T>
{
    
    public static void Visit(Vertex<T> v, IDirectedWeightedGraph<T> graph, HashSet<Vertex<T>> visited, Stack<Vertex<T>> reversed)
    {
        if (visited.Contains(v))
        {
            return;
        }

        visited.Add(v);

        reversed.Push(v);

        foreach (var u in graph.GetNeighbors(v))
        {
            Visit(u!, graph, visited, reversed);
        }
    }

    public static void Assign(Vertex<T> v, Vertex<T> root, IDirectedWeightedGraph<T> graph, Dictionary<Vertex<T>, Vertex<T>> roots)
    {
        
        if (roots.ContainsKey(v))
        {
            return;
        }

        roots.Add(v, root);

        foreach (var u in graph.GetNeighbors(v))
        {
            Assign(u!, root, graph, roots);
        }
    }

    public static Dictionary<Vertex<T>, Vertex<T>> GetRepresentatives(IDirectedWeightedGraph<T> graph)
    {
        HashSet<Vertex<T>> visited = new HashSet<Vertex<T>>();
        Stack<Vertex<T>> reversedL = new Stack<Vertex<T>>();
        Dictionary<Vertex<T>, Vertex<T>> representatives = new Dictionary<Vertex<T>, Vertex<T>>();

        foreach (var v in graph.Vertices)
        {
            if (v != null)
            {
                Visit(v, graph, visited, reversedL);
            }
        }

        visited.Clear();

        while (reversedL.Count > 0)
        {
            Vertex<T> v = reversedL.Pop();
            Assign(v, v, graph, representatives);
        }

        return representatives;
    }

    public static IEnumerable<Vertex<T>>[] GetScc(IDirectedWeightedGraph<T> graph)
    {
        var representatives = GetRepresentatives(graph);
        Dictionary<Vertex<T>, List<Vertex<T>>> scc = new Dictionary<Vertex<T>, List<Vertex<T>>>();
        foreach (var kv in representatives)
        {
            
            if (scc.ContainsKey(kv.Value))
            {
                scc[kv.Value].Add(kv.Key);
            }
            else
            {
                scc.Add(kv.Value, new List<Vertex<T>> { kv.Key });
            }
        }

        return scc.Values.ToArray();
    }
}
