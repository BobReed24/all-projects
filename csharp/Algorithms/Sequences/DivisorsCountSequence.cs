using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class DivisorsCountSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return BigInteger.One;
            for (var n = new BigInteger(2); ; n++)
            {
                var count = 2;
                for (var k = 2; k < n; k++)
                {
                    BigInteger.DivRem(n, k, out var remainder);
                    if (remainder == 0)
                    {
                        count++;
                    }
                }

                yield return count;
            }
        }
    }
}
