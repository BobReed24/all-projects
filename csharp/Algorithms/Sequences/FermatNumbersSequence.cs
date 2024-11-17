using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class FermatNumbersSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = new BigInteger(2);

            while (true)
            {
                yield return n + 1;
                n *= n;
            }
        }
    }
}
