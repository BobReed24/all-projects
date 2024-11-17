using System;
using System.Collections.Generic;

namespace Algorithms.Strings.Similarity;

public static class CosineSimilarity
{
    
    public static double Calculate(string left, string right)
    {
        
        var vectors = GetVectors(left.ToLowerInvariant(), right.ToLowerInvariant());
        var leftVector = vectors.LeftVector;
        var rightVector = vectors.RightVector;

        var intersection = GetIntersection(leftVector, rightVector);

        var dotProduct = DotProduct(leftVector, rightVector, intersection);

        var mLeft = 0.0;
        foreach (var value in leftVector.Values)
        {
            mLeft += value * value;
        }

        var mRight = 0.0;
        foreach (var value in rightVector.Values)
        {
            mRight += value * value;
        }

        if (mLeft <= 0 || mRight <= 0)
        {
            return 0.0;
        }

        return dotProduct / (Math.Sqrt(mLeft) * Math.Sqrt(mRight));
    }

    private static (Dictionary<char, int> LeftVector, Dictionary<char, int> RightVector) GetVectors(string left, string right)
    {
        var leftVector = new Dictionary<char, int>();
        var rightVector = new Dictionary<char, int>();

        foreach (var character in left)
        {
            leftVector.TryGetValue(character, out var frequency);
            leftVector[character] = ++frequency;
        }

        foreach (var character in right)
        {
            rightVector.TryGetValue(character, out var frequency);
            rightVector[character] = ++frequency;
        }

        return (leftVector, rightVector);
    }

    private static double DotProduct(Dictionary<char, int> leftVector, Dictionary<char, int> rightVector, HashSet<char> intersection)
    {
        
        double dotProduct = 0;

        foreach (var character in intersection)
        {
            
            dotProduct += leftVector[character] * rightVector[character];
        }

        return dotProduct;
    }

    private static HashSet<char> GetIntersection(Dictionary<char, int> leftVector, Dictionary<char, int> rightVector)
    {
        
        var intersection = new HashSet<char>();

        foreach (var kvp in leftVector)
        {
            
            if (rightVector.ContainsKey(kvp.Key))
            {
                intersection.Add(kvp.Key);
            }
        }

        return intersection;
    }
}
