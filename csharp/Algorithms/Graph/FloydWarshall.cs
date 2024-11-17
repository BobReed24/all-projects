using System;
using DataStructures.Graph;

namespace Algorithms.Graph;

public class FloydWarshall<T>
{
    
    public double[,] Run(DirectedWeightedGraph<T> graph)
    {
        var distances = SetupDistances(graph);
        var vertexCount = distances.GetLength(0);
        for (var k = 0; k < vertexCount; k++)
        {
            for (var i = 0; i < vertexCount; i++)
            {
                for (var j = 0; j < vertexCount; j++)
                {
                    distances[i, j] = distances[i, j] > distances[i, k] + distances[k, j]
                    ? distances[i, k] + distances[k, j]
                    : distances[i, j];
                }
            }
        }

        return distances;
    }

    private double[,] SetupDistances(DirectedWeightedGraph<T> graph)
    {
        var distances = new double[graph.Count, graph.Count];
        for (int i = 0; i < distances.GetLength(0); i++)
        {
            for (var j = 0; j < distances.GetLength(0); j++)
            {
                var dist = graph.AdjacentDistance(graph.Vertices[i]!, graph.Vertices[j]!);
                distances[i, j] = dist != 0 ? dist : double.PositiveInfinity;
            }
        }

        for (var i = 0; i < distances.GetLength(0); i++)
        {
            distances[i, i] = 0;
        }

        return distances;
    }
}
