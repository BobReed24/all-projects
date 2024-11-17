using System;

namespace Algorithms.Strings.Similarity;

public static class DamerauLevenshteinDistance
{
    
    public static int Calculate(string left, string right)
    {
        
        var leftSize = left.Length;
        var rightSize = right.Length;

        var distances = InitializeDistanceArray(leftSize, rightSize);

        for (var i = 1; i < leftSize + 1; i++)
        {
            
            for (var j = 1; j < rightSize + 1; j++)
            {
                
                var cost = left[i - 1] == right[j - 1] ? 0 : 1;

                distances[i, j] = Math.Min(
                    Math.Min(
                        distances[i - 1, j] + 1, 
                        distances[i, j - 1] + 1), 
                    distances[i - 1, j - 1] + cost); 

                if (i > 1 && j > 1 && left[i - 1] == right[j - 2] && left[i - 2] == right[j - 1])
                {
                    distances[i, j] = Math.Min(
                        distances[i, j], 
                        distances[i - 2, j - 2] + cost); 
                }
            }
        }

        return distances[leftSize, rightSize];
    }

    private static int[,] InitializeDistanceArray(int leftSize, int rightSize)
    {
        
        var matrix = new int[leftSize + 1, rightSize + 1];

        for (var i = 1; i < leftSize + 1; i++)
        {
            matrix[i, 0] = i;
        }

        for (var i = 1; i < rightSize + 1; i++)
        {
            matrix[0, i] = i;
        }

        return matrix;
    }
}
