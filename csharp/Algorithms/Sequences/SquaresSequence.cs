using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class SquaresSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = new BigInteger(0);

            while (true)
            {
                yield return n * n;
                n++;
            }
        }
    }
}
