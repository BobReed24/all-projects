using System;

namespace Algorithms.Problems.DynamicProgramming;

public static class LevenshteinDistance
{
    
    public static int Calculate(string source, string target)
    {
        var distances = new int[source.Length + 1, target.Length + 1];

        for(var i = 0; i <= source.Length; i++)
        {
            distances[i, 0] = i;
        }

        for (var i = 0; i <= target.Length; i++)
        {
            distances[0, i] = i;
        }

        for (var i = 1; i <= source.Length; i++)
        {
            for (var j = 1; j <= target.Length; j++)
            {
                var substitionCost = source[i - 1] == target[j - 1] ? 0 : 1;
                distances[i, j] = Math.Min(distances[i - 1, j] + 1, Math.Min(distances[i, j - 1] + 1, distances[i - 1, j - 1] + substitionCost));
            }
        }

        return distances[source.Length, target.Length];
    }
}
