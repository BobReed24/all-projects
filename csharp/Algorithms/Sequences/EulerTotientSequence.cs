using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Sequences;

public class EulerTotientSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return BigInteger.One;

            for (BigInteger i = 2; ; i++)
            {
                var n = i;
                var result = n;

                var factors = PrimeFactors(i);
                foreach (var factor in factors)
                {
                    while (n % factor == 0)
                    {
                        n /= factor;
                    }

                    result -= result / factor;
                }

                if (n > 1)
                {
                    result -= result / n;
                }

                yield return result;
            }
        }
    }

    private static IEnumerable<BigInteger> PrimeFactors(BigInteger target)
    {
        return new PrimesSequence()
              .Sequence.TakeWhile(prime => prime * prime <= target)
              .Where(prime => target % prime == 0)
              .ToList();
    }
}
