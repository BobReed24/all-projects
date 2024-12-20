using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class PowersOf2Sequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = new BigInteger(1);

            while (true)
            {
                yield return n;
                n *= 2;
            }
        }
    }
}
