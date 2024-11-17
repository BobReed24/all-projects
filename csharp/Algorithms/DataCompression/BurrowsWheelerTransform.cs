using System;
using System.Linq;

namespace Algorithms.DataCompression;

public class BurrowsWheelerTransform
{
    
    public (string Encoded, int Index) Encode(string s)
    {
        if (s.Length == 0)
        {
            return (string.Empty, 0);
        }

        var rotations = GetRotations(s);
        Array.Sort(rotations, StringComparer.Ordinal);
        var lastColumn = rotations
            .Select(x => x[^1])
            .ToArray();
        var encoded = new string(lastColumn);
        return (encoded, Array.IndexOf(rotations, s));
    }

    public string Decode(string s, int index)
    {
        if (s.Length == 0)
        {
            return string.Empty;
        }

        var rotations = new string[s.Length];

        for (var i = 0; i < s.Length; i++)
        {
            for (var j = 0; j < s.Length; j++)
            {
                rotations[j] = s[j] + rotations[j];
            }

            Array.Sort(rotations, StringComparer.Ordinal);
        }

        return rotations[index];
    }

    private string[] GetRotations(string s)
    {
        var result = new string[s.Length];

        for (var i = 0; i < s.Length; i++)
        {
            result[i] = s.Substring(i) + s.Substring(0, i);
        }

        return result;
    }
}
