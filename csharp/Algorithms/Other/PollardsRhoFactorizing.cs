using System;
using Algorithms.Numeric.GreatestCommonDivisor;

namespace Algorithms.Other;

public static class PollardsRhoFactorizing
{
    public static int Calculate(int number)
    {
        var x = 2;
        var y = 2;
        var d = 1;
        var p = number;
        var i = 0;
        var gcd = new BinaryGreatestCommonDivisorFinder();

        while (d == 1)
        {
            x = Fun_g(x, p);
            y = Fun_g(Fun_g(y, p), p);
            d = gcd.FindGcd(Math.Abs(x - y), p);
            i++;
        }

        return d;
    }

    private static int Fun_g(int x, int p)
    {
        return (x * x + 1) % p;
    }
}
