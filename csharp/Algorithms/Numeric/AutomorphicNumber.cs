using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Numeric;

public static class AutomorphicNumber
{
    
    public static IEnumerable<int> GetAutomorphicNumbers(int lowerBound, int upperBound)
    {
        if (lowerBound < 1)
        {
            throw new ArgumentException($"Lower bound must be greater than 0.");
        }

        if (upperBound < 1)
        {
            throw new ArgumentException($"Upper bound must be greater than 0.");
        }

        if (lowerBound > upperBound)
        {
            throw new ArgumentException($"The lower bound must be less than or equal to the upper bound.");
        }

        return Enumerable.Range(lowerBound, upperBound).Where(IsAutomorphic);
    }

    public static bool IsAutomorphic(int number)
    {
        if (number < 1)
        {
            throw new ArgumentException($"An automorphic number must always be positive.");
        }

        BigInteger square = BigInteger.Pow(number, 2);

        while (number > 0)
        {
            if (number % 10 != square % 10)
            {
                return false;
            }

            number /= 10;
            square /= 10;
        }

        return true;
    }
}
