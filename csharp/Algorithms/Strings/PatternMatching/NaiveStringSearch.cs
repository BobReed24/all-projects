using System.Collections.Generic;

namespace Algorithms.Strings.PatternMatching;

public static class NaiveStringSearch
{
    
    public static int[] NaiveSearch(string content, string pattern)
    {
        var m = pattern.Length;
        var n = content.Length;
        List<int> indices = new();
        for (var e = 0; e <= n - m; e++)
        {
            int j;
            for (j = 0; j < m; j++)
            {
                if (content[e + j] != pattern[j])
                {
                    break;
                }
            }

            if (j == m)
            {
                indices.Add(e);
            }
        }

        return indices.ToArray();
    }
}
