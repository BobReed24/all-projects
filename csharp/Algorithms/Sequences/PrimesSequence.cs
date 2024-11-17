using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Sequences;

public class PrimesSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 2;
            var primes = new List<BigInteger>
            {
                2,
            };
            var n = new BigInteger(3);

            while (true)
            {
                if (primes.All(p => n % p != 0))
                {
                    yield return n;
                    primes.Add(n);
                }

                n += 2;
            }
        }
    }
}
