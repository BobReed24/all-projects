using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class BinomialSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var i = 0;

            while (true)
            {
                var row = GenerateRow(i);
                foreach (var coefficient in row)
                {
                    yield return coefficient;
                }

                i++;
            }
        }
    }

    private static BigInteger BinomialCoefficient(long n, long k)
    {
        if (k == 0 || k == n)
        {
            return new BigInteger(1);
        }

        if (n < 0)
        {
            return new BigInteger(0);
        }

        return BinomialCoefficient(n - 1, k) + BinomialCoefficient(n - 1, k - 1);
    }

    private static IEnumerable<BigInteger> GenerateRow(long n)
    {
        long k = 0;

        while (k <= n)
        {
            yield return BinomialCoefficient(n, k);
            k++;
        }
    }
}
