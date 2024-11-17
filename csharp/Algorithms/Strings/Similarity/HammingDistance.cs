using System;

namespace Algorithms.Strings.Similarity;

public static class HammingDistance
{
    
    public static int Calculate(string s1, string s2)
    {
        if(s1.Length != s2.Length)
        {
            throw new ArgumentException("Strings must be equal length.");
        }

        var distance = 0;
        for (var i = 0; i < s1.Length; i++)
        {
            distance += s1[i] != s2[i] ? 1 : 0;
        }

        return distance;
    }
}
