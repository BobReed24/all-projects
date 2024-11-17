using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class PrimorialNumbersSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var primes = new PrimesSequence().Sequence;
            var n = new BigInteger(1);

            foreach (var p in primes)
            {
                yield return n;
                n *= p;
            }
        }
    }
}
