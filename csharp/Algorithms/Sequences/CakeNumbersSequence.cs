using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class CakeNumbersSequence : ISequence
{
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = new BigInteger(0);
            while (true)
            {
                var next = (BigInteger.Pow(n, 3) + 5 * n + 6) / 6;
                n++;
                yield return next;
            }
        }
    }
}
