using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class TetrahedralSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var index = BigInteger.Zero;
            var six = new BigInteger(6);
            while (true)
            {
                yield return BigInteger.Divide(index * (index + 1) * (index + 2), six);
                index++;
            }
        }
    }
}
