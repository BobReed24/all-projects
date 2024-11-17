using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class OnesCountingSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 0;
            var depth = 0;
            while (true)
            {
                foreach (var count in GenerateFractalCount(BigInteger.One, depth))
                {
                    yield return count;
                }

                depth++;
            }
        }
    }

    private static IEnumerable<BigInteger> GenerateFractalCount(BigInteger i, int depth)
    {
        
        if (depth == 0)
        {
            yield return i;
            yield break;
        }

        foreach (var firstHalf in GenerateFractalCount(i, depth - 1))
        {
            yield return firstHalf;
        }

        foreach (var secondHalf in GenerateFractalCount(i + 1, depth - 1))
        {
            yield return secondHalf;
        }
    }
}
