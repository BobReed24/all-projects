using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class AllThreesSequence : ISequence
{
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            while (true)
            {
                yield return 3;
            }
        }
    }
}
