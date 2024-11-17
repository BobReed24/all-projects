using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class ZeroSequence : ISequence
{
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            while (true)
            {
                yield return 0;
            }
        }
    }
}
