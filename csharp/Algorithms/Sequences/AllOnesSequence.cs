using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class AllOnesSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            while (true)
            {
                yield return 1;
            }
        }
    }
}
