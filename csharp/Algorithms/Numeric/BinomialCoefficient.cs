using System;
using System.Numerics;

namespace Algorithms.Numeric;

public static class BinomialCoefficient
{
    
    public static BigInteger Calculate(BigInteger num, BigInteger k)
    {
        if (num < k || k < 0)
        {
            throw new ArgumentException("num ≥ k ≥ 0");
        }

        k = BigInteger.Min(k, num - k);

        var numerator = BigInteger.One;
        for (var val = num - k + 1; val <= num; val++)
        {
            numerator *= val;
        }

        var denominator = BigInteger.One;
        for (var val = k; val > BigInteger.One; val--)
        {
            denominator *= val;
        }

        return numerator / denominator;
    }
}
