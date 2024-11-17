using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class EuclidNumbersSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var primorialNumbers = new PrimorialNumbersSequence().Sequence;

            foreach (var n in primorialNumbers)
            {
                yield return n + 1;
            }
        }
    }
}
