using System;

namespace Algorithms.Strings.PatternMatching;

public static class Bitap
{
    
    public static int FindExactPattern(string text, string pattern)
    {
        
        var len = pattern.Length;

        var patternMask = new int[128];
        int index;

        if (string.IsNullOrEmpty(pattern))
        {
            return 0;
        }

        if (len > 31)
        {
            throw new ArgumentException("The pattern is longer than 31 characters.");
        }

        var r = ~1;

        for (index = 0; index <= 127; ++index)
        {
            patternMask[index] = ~0;
        }

        for (index = 0; index < len; ++index)
        {
            patternMask[pattern[index]] &= ~(1 << index);
        }

        for (index = 0; index < text.Length; ++index)
        {
            
            r |= patternMask[text[index]];
            r <<= 1;

            if ((r & 1 << len) == 0)
            {
                return index - len + 1;
            }
        }

        return -1;
    }

    public static int FindFuzzyPattern(string text, string pattern, int threshold)
    {
        
        var patternMask = new int[128];

        var r = new int[(threshold + 1) * sizeof(int)];

        var len = pattern.Length;

        if (string.IsNullOrEmpty(text))
        {
            return 0;
        }

        if (string.IsNullOrEmpty(pattern))
        {
            return 0;
        }

        if (len > 31)
        {
            return -1;
        }

        for (var i = 0; i <= threshold; ++i)
        {
            r[i] = ~1;
        }

        for (var i = 0; i <= 127; i++)
        {
            patternMask[i] = ~0;
        }

        for (var i = 0; i < len; ++i)
        {
            patternMask[pattern[i]] &= ~(1 << i);
        }

        for (var i = 0; i < text.Length; ++i)
        {
            
            var oldR = r[0];

            r[0] |= patternMask[text[i]];
            r[0] <<= 1;

            for (var j = 1; j <= threshold; ++j)
            {
                var tmp = r[j];

                r[j] = (oldR & (r[j] | patternMask[text[i]])) << 1;
                oldR = tmp;
            }

            if ((r[threshold] & 1 << len) == 0)
            {
                
                return i - len + 1;
            }
        }

        return -1;
    }
}
