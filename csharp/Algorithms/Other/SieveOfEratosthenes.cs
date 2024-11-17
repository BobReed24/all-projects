using System;
using System.Collections.Generic;

namespace Algorithms.Other;

public class SieveOfEratosthenes
{
    private readonly bool[] primes;

    public SieveOfEratosthenes(long maximumNumberToCheck)
    {
        primes = new bool[maximumNumberToCheck + 1];

        Array.Fill(this.primes, true, 2, primes.Length - 2);

        for(long i = 2; i * i <= maximumNumberToCheck; i++)
        {
            if (!primes[i])
            {
                continue;
            }

            for(long composite = i * i; composite <= maximumNumberToCheck; composite += i)
            {
                primes[composite] = false;
            }
        }
    }

    public long MaximumNumber => primes.Length - 1;

    public bool IsPrime(long numberToCheck) => primes[numberToCheck];

    public IEnumerable<long> GetPrimes()
    {
        for(long i = 2; i < primes.Length; i++)
        {
            if (primes[i])
            {
                yield return i;
            }
        }
    }
}
