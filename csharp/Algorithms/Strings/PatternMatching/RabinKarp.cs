using System;
using System.Collections.Generic;

namespace Algorithms.Strings.PatternMatching;

public static class RabinKarp
{
    
    public static List<int> FindAllOccurrences(string text, string pattern)
    {
        
        const ulong p = 65537;

        const ulong m = (ulong)1e9 + 7;

        ulong[] pPow = new ulong[Math.Max(pattern.Length, text.Length)];
        pPow[0] = 1;
        for (var i = 1; i < pPow.Length; i++)
        {
            pPow[i] = pPow[i - 1] * p % m;
        }

        ulong[] hashT = new ulong[text.Length + 1];
        for (var i = 0; i < text.Length; i++)
        {
            hashT[i + 1] = (hashT[i] + text[i] * pPow[i]) % m;
        }

        ulong hashS = 0;
        for (var i = 0; i < pattern.Length; i++)
        {
            hashS = (hashS + pattern[i] * pPow[i]) % m;
        }

        List<int> occurrences = new();
        for (var i = 0; i + pattern.Length - 1 < text.Length; i++)
        {
            
            var currentHash = (hashT[i + pattern.Length] + m - hashT[i]) % m;

            if (currentHash == hashS * pPow[i] % m)
            {
                
                var j = 0;
                while (j < pattern.Length && text[i + j] == pattern[j])
                {
                    ++j;
                }

                if (j == pattern.Length)
                {
                    
                    occurrences.Add(i);
                }
            }
        }

        return occurrences;
    }
}
