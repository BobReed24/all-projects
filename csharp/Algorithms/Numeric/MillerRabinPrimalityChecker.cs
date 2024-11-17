using System;
using System.Numerics;

namespace Algorithms.Numeric;

public static class MillerRabinPrimalityChecker
{
    
    public static bool IsProbablyPrimeNumber(BigInteger n, BigInteger rounds, int? seed = null)
    {
        Random rand = seed is null
            ? new()
            : new(seed.Value);
        return IsProbablyPrimeNumber(n, rounds, rand);
    }

    private static bool IsProbablyPrimeNumber(BigInteger n, BigInteger rounds, Random rand)
    {
        if (n <= 3)
        {
            throw new ArgumentException($"{nameof(n)} should be more than 3");
        }

        BigInteger r = 0;
        BigInteger d = n - 1;
        while (d % 2 == 0)
        {
            r++;
            d /= 2;
        }

        int nMaxValue = (n > int.MaxValue) ? int.MaxValue : (int)n;
        BigInteger a = rand.Next(2, nMaxValue - 2); 

        while (rounds > 0)
        {
            rounds--;
            var x = BigInteger.ModPow(a, d, n);
            if (x == 1 || x == (n - 1))
            {
                continue;
            }

            BigInteger tempr = r - 1;
            while (tempr > 0 && (x != n - 1))
            {
                tempr--;
                x = BigInteger.ModPow(x, 2, n);
            }

            if (x == n - 1)
            {
                continue;
            }

            return false;
        }

        return true;
    }
}
