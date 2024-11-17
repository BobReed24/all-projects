using System;

namespace Algorithms.Strings.Similarity;

public static class JaroSimilarity
{
    
    public static double Calculate(string s1, string s2)
    {
        if (s1 == s2)
        {
            return 1;
        }

        var longerString = s1.Length > s2.Length ? s1 : s2;
        var shorterString = s1.Length < s2.Length ? s1 : s2;

        var matchingCharacterRange = Math.Max((longerString.Length / 2) - 1, 0);
        var matches = 0d;

        var s1MatchedIndeces = new bool[s1.Length];

        var s2MatchedIndeces = new bool[s2.Length];

        for (var i = 0; i < longerString.Length; i++)
        {
            var startIndex = Math.Max(i - matchingCharacterRange, 0);
            var endIndex = Math.Min(i + matchingCharacterRange, shorterString.Length - 1);
            for (var j = startIndex; j <= endIndex; j++)
            {
                if (s1[i] == s2[j] && !s2MatchedIndeces[j])
                {
                    matches++;
                    s1MatchedIndeces[i] = true;
                    s2MatchedIndeces[j] = true;
                    break;
                }
            }
        }

        if (matches == 0)
        {
            return 0;
        }

        var transpositions = CalculateTranspositions(s1, s2, s1MatchedIndeces, s2MatchedIndeces);

        return ((matches / s1.Length) + (matches / s2.Length) + ((matches - transpositions) / matches)) / 3;
    }

    private static int CalculateTranspositions(string s1, string s2, bool[] s1MatchedIndeces, bool[] s2MatchedIndeces)
    {
        var transpositions = 0;
        var s2Index = 0;
        for (var s1Index = 0; s1Index < s1.Length; s1Index++)
        {
            if (s1MatchedIndeces[s1Index])
            {
                while (!s2MatchedIndeces[s2Index])
                {
                    s2Index++;
                }

                if (s1[s1Index] != s2[s2Index])
                {
                    transpositions++;
                }

                s2Index++;
            }
        }

        transpositions /= 2;
        return transpositions;
    }
}
