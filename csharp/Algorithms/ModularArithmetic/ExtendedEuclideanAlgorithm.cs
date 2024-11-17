using System.Numerics;

namespace Algorithms.ModularArithmetic;

public static class ExtendedEuclideanAlgorithm
{
    
    public static ExtendedEuclideanAlgorithmResult<long> Compute(long a, long b)
    {
        long quotient;
        long tmp;
        var s = 0L;
        var bezoutOfA = 1L;
        var r = b;
        var gcd = a;
        var bezoutOfB = 0L;

        while (r != 0)
        {
            quotient = gcd / r; 

            tmp = gcd;
            gcd = r;
            r = tmp - quotient * r;

            tmp = bezoutOfA;
            bezoutOfA = s;
            s = tmp - quotient * s;
        }

        if (b != 0)
        {
            bezoutOfB = (gcd - bezoutOfA * a) / b; 
        }

        return new ExtendedEuclideanAlgorithmResult<long>(bezoutOfA, bezoutOfB, gcd);
    }

    public static ExtendedEuclideanAlgorithmResult<BigInteger> Compute(BigInteger a, BigInteger b)
    {
        BigInteger quotient;
        BigInteger tmp;
        var s = BigInteger.Zero;
        var bezoutOfA = BigInteger.One;
        var r = b;
        var gcd = a;
        var bezoutOfB = BigInteger.Zero;

        while (r != 0)
        {
            quotient = gcd / r; 

            tmp = gcd;
            gcd = r;
            r = tmp - quotient * r;

            tmp = bezoutOfA;
            bezoutOfA = s;
            s = tmp - quotient * s;
        }

        if (b != 0)
        {
            bezoutOfB = (gcd - bezoutOfA * a) / b; 
        }

        return new ExtendedEuclideanAlgorithmResult<BigInteger>(bezoutOfA, bezoutOfB, gcd);
    }

    public record ExtendedEuclideanAlgorithmResult<T>(T BezoutA, T BezoutB, T Gcd);
}
