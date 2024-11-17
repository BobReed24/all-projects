using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Sequences;

public class KummerNumbersSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var primorialNumbers = new PrimorialNumbersSequence().Sequence.Skip(1);

            foreach (var n in primorialNumbers)
            {
                yield return n - 1;
            }
        }
    }
}
