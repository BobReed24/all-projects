using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class BinaryPrimeConstantSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            ISequence primes = new PrimesSequence();
            var n = new BigInteger(0);

            foreach (var p in primes.Sequence)
            {
                for (n++; n < p; n++)
                {
                    yield return 0;
                }

                yield return 1;
            }
        }
    }
}
