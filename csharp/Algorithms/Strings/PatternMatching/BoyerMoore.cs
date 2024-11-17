using System;

namespace Algorithms.Strings.PatternMatching;

public static class BoyerMoore
{
    
    public static int FindFirstOccurrence(string t, string p)
    {
        
        var m = p.Length;

        var n = t.Length;

        int[] badChar = BadCharacterRule(p, m);

        int[] goodSuffix = GoodSuffixRule(p, m);

        var i = 0;

        int j;

        while (i <= n - m)
        {
            
            j = m - 1;

            while (j >= 0 && p[j] == t[i + j])
            {
                j--;
            }

            if (j < 0)
            {
                return i;
            }

            i += Math.Max(goodSuffix[j + 1], j - badChar[t[i + j]]);
        }

        return -1;
    }

    private static int[] BadCharacterRule(string p, int m)
    {
        
        int[] badChar = new int[256];
        Array.Fill(badChar, -1);

        for (var j = 0; j < m; j++)
        {
            badChar[p[j]] = j;
        }

        return badChar;
    }

    private static int[] GoodSuffixRule(string p, int m)
    {
        
        int[] f = new int[p.Length + 1];

        f[m] = m + 1;

        int[] s = new int[p.Length + 1];

        var i = m;

        var j = m + 1;

        while (i > 0)
        {
            
            while (j <= m && p[i - 1] != p[j - 1])
            {
                if (s[j] == 0)
                {
                    s[j] = j - i;
                }

                j = f[j];
            }

            --i;
            --j;
            f[i] = j;
        }

        j = f[0];
        for (i = 0; i <= m; i++)
        {
            
            if (s[i] == 0)
            {
                s[i] = j;
            }

            if (i == j)
            {
                j = f[j];
            }
        }

        return s;
    }
}
