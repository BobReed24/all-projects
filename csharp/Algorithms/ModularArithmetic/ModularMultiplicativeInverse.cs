using System;
using System.Numerics;

namespace Algorithms.ModularArithmetic;

public static class ModularMultiplicativeInverse
{
    
    public static long Compute(long a, long n)
    {
        var eeaResult = ExtendedEuclideanAlgorithm.Compute(a, n);

        if (eeaResult.Gcd != 1)
        {
            throw new ArithmeticException($"{a} is not invertible in Z/{n}Z.");
        }

        var inverseOfA = eeaResult.BezoutA;
        if (inverseOfA < 0)
        {
            inverseOfA += n;
        }

        return inverseOfA;
    }

    public static BigInteger Compute(BigInteger a, BigInteger n)
    {
        var eeaResult = ExtendedEuclideanAlgorithm.Compute(a, n);

        if (eeaResult.Gcd != 1)
        {
            throw new ArithmeticException($"{a} is not invertible in Z/{n}Z.");
        }

        var inverseOfA = eeaResult.BezoutA;
        if (inverseOfA < 0)
        {
            inverseOfA += n;
        }

        return inverseOfA;
    }
}
