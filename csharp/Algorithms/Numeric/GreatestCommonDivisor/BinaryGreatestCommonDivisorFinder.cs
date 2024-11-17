using System;

namespace Algorithms.Numeric.GreatestCommonDivisor;

public class BinaryGreatestCommonDivisorFinder : IGreatestCommonDivisorFinder
{
    public int FindGcd(int u, int v)
    {
        
        if (u == 0 && v == 0)
        {
            return 0;
        }

        if (u == 0 || v == 0)
        {
            return u + v;
        }

        u = Math.Sign(u) * u;
        v = Math.Sign(v) * v;

        var shift = 0;
        while (((u | v) & 1) == 0)
        {
            u >>= 1;
            v >>= 1;
            shift++;
        }

        while ((u & 1) == 0)
        {
            u >>= 1;
        }

        do
        {
            
            while ((v & 1) == 0)
            {
                v >>= 1;
            }

            if (u > v)
            {
                var t = v;
                v = u;
                u = t;
            }

            v -= u;
        }
        while (v != 0);

        return u << shift;
    }
}
