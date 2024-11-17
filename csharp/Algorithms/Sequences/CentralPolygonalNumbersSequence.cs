using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class CentralPolygonalNumbersSequence : ISequence
{
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = new BigInteger(0);
            while (true)
            {
                var next = n * (n + 1) / 2 + 1;
                n++;
                yield return next;
            }
        }
    }
}
