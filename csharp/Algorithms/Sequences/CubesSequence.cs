using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class CubesSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = BigInteger.Zero;

            while (true)
            {
                yield return n * n * n;
                n++;
            }
        }
    }
}
