using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class NumberOfPrimesByNumberOfDigitsSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            ISequence primes = new PrimesSequence();
            var powerOf10 = new BigInteger(1);
            var counter = new BigInteger(0);

            foreach (var p in primes.Sequence)
            {
                if (p > powerOf10)
                {
                    yield return counter;
                    counter = 0;
                    powerOf10 *= 10;
                }

                counter++;
            }
        }
    }
}
